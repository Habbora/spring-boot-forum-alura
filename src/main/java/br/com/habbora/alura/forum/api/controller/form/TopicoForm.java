package br.com.habbora.alura.forum.api.controller.form;

import br.com.habbora.alura.forum.modelo.Topico;
import br.com.habbora.alura.forum.repository.CursoRepository;
import br.com.habbora.alura.forum.repository.TopicoRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class TopicoForm {

    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;
    @NotBlank
    private String nomeCurso;

    // Metodos Especiais;
    public Topico getTopico(CursoRepository cursoRepository) {
        Topico topico = new Topico();
        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);
        topico.setCurso(cursoRepository.findByNome(nomeCurso));
        return topico;
    }

    //Getters and Setters below;
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}
