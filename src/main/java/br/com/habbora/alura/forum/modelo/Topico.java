package br.com.habbora.alura.forum.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private TopicoStatus status = TopicoStatus.NAO_RESPONDIDO;
    private String titulo;
    private String mensagem;
    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    // Outras coisas


    // Getters and Setters bellow;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TopicoStatus getStatus() {
        return status;
    }

    public void setStatus(TopicoStatus status) {
        this.status = status;
    }

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

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}
