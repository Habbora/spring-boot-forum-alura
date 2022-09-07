package br.com.habbora.alura.forum.api.controller;

import br.com.habbora.alura.forum.api.controller.dto.DetalharTopicoDto;
import br.com.habbora.alura.forum.api.controller.dto.TopicoDto;
import br.com.habbora.alura.forum.api.controller.form.AtualizarTopicoForm;
import br.com.habbora.alura.forum.api.controller.form.TopicoForm;
import br.com.habbora.alura.forum.modelo.Topico;
import br.com.habbora.alura.forum.repository.CursoRepository;
import br.com.habbora.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    @Cacheable(value = "listaDeTopicos")
    Page<TopicoDto> listarTopicos(@RequestParam(required = false) String nomeCurso,
                                  @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10)
                                  Pageable paginacao) {
        if (nomeCurso == null) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            return TopicoDto.toPage(topicos);
        } else {
            Page<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso, paginacao);
            return TopicoDto.toPage(topicos);
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    ResponseEntity<TopicoDto> cadastrarTopico(@Valid @RequestBody TopicoForm topicoForm,
                                              UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoForm.getTopico(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    ResponseEntity<DetalharTopicoDto> detalharTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(new DetalharTopicoDto(optionalTopico.get()));
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    ResponseEntity<TopicoDto> atualizarTopico(@PathVariable Long id,
                                              @Valid @RequestBody AtualizarTopicoForm atualizarTopicoForm) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) return ResponseEntity.notFound().build();

        Topico topico = atualizarTopicoForm.atualizarTopico(optionalTopico.get());
        topicoRepository.save(topico);
        return ResponseEntity.ok().body(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    ResponseEntity<?> removerTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (!optionalTopico.isPresent()) return ResponseEntity.notFound().build();
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
