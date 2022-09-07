package br.com.habbora.alura.forum.repository;

import br.com.habbora.alura.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

}
