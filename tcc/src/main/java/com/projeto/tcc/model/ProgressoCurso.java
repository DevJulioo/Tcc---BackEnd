package com.projeto.tcc.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(name = "progresso_cursos", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuarioId", "nomeCurso"})})
@Entity

public class ProgressoCurso {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long usuarioId;

	    private String nomeCurso;

	    private String status;

	    private LocalDateTime dataAtualizacao = LocalDateTime.now();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getUsuarioId() {
			return usuarioId;
		}

		public void setUsuarioId(Long usuarioId) {
			this.usuarioId = usuarioId;
		}

		public String getNomeCurso() {
			return nomeCurso;
		}

		public void setNomeCurso(String nomeCurso) {
			this.nomeCurso = nomeCurso;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public LocalDateTime getDataAtualizacao() {
			return dataAtualizacao;
		}

		public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
		}
	    
	    

}


