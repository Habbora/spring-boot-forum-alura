package br.com.habbora.alura.forum.api.controller.dto;

import br.com.habbora.alura.forum.modelo.Resposta;
import br.com.habbora.alura.forum.modelo.Topico;
import br.com.habbora.alura.forum.modelo.TopicoStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalharTopicoDto {

    private Long id;
    private String autor;
    private TopicoStatus status;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private String titulo;
    private String mensagem;
    private List<RespostaDto> respostas;

    public DetalharTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.autor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.dataCriacao = topico.getDataCriacao();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public TopicoStatus getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<RespostaDto> getRespostas() {
        return respostas;
    }
}
