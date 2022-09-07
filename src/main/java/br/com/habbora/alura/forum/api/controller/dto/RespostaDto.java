package br.com.habbora.alura.forum.api.controller.dto;

import br.com.habbora.alura.forum.modelo.Resposta;
import br.com.habbora.alura.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RespostaDto {

    private Long id;
    private String autor;
    private LocalDateTime dataCriacao;
    private String mensagem;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.autor = resposta.getAutor().getNome();
        this.dataCriacao = resposta.getDataCriacao();
        this.mensagem = resposta.getMensagem();
    }

    public static List<RespostaDto> toList(List<Resposta> respostas) {
        return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getAutor() {
        return autor;
    }
}
