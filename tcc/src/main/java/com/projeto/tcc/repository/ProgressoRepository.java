package com.projeto.tcc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.tcc.model.ProgressoCurso;

@Repository
public interface ProgressoRepository extends JpaRepository<ProgressoCurso, Long> {
    // Este método é criado automaticamente pelo Spring Data JPA
    // Ele encontra um progresso pelo ID do usuário e o nome do curso
    Optional<ProgressoCurso> findByUsuarioIdAndNomeCurso(Long usuarioId, String nomeCurso);
}
