package br.com.habbora.alura.forum.api.controller.form;

import br.com.habbora.alura.forum.modelo.Topico;
import br.com.habbora.alura.forum.repository.CursoRepository;

import javax.validation.constraints.NotBlank;

public class AtualizarTopicoForm {

    @NotBlank
    private String titulo;
    @NotBlank
    private String mensagem;

    // Metodos Especiais;
    public Topico getTopico(CursoRepository cursoRepository) {
        Topico topico = new Topico();
        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);
        return topico;
    }

    public Topico atualizarTopico(Topico topico) {
        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);
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
}
