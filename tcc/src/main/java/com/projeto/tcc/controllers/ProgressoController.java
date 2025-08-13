package com.projeto.tcc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.tcc.model.ProgressoCurso;
import com.projeto.tcc.repository.ProgressoRepository;

@RestController
@RequestMapping("/api")
public class ProgressoController {

    @Autowired
    private ProgressoRepository progressoRepository;

    @PostMapping("/progresso")
    public ResponseEntity<String> atualizarProgresso(@RequestBody ProgressoCurso progresso) {
        // Simulação do ID do usuário. Em um projeto real, você usaria Spring Security
        // para obter o usuário autenticado.
        Long usuarioId = 1L;
        progresso.setUsuarioId(usuarioId);

        // Verifica se já existe um progresso para o curso do usuário
        Optional<ProgressoCurso> progressoExistente = progressoRepository.findByUsuarioIdAndNomeCurso(usuarioId, progresso.getNomeCurso());

        if (progressoExistente.isPresent()) {
            // Se existir, atualiza o status e a data
            ProgressoCurso progressoToUpdate = progressoExistente.get();
            progressoToUpdate.setStatus(progresso.getStatus());
            progressoRepository.save(progressoToUpdate);
            return ResponseEntity.ok("Progresso do curso atualizado com sucesso!");
        } else {
            // Se não existir, salva um novo registro
            progressoRepository.save(progresso);
            return ResponseEntity.ok("Novo progresso de curso salvo com sucesso!");
        }
    }
}
