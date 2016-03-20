package com.eg.learning.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = UfEntity.NAME)
@Table(name = UfEntity.NAME)
public class UfEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 3725232287965723730L;

	public static final String NAME = "Uf";
	public static final String SEQUENCE = "S_UF";

	@Id
	@GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
	private Long id;
	
	@Size(max = 255, message = "O nome da UF pode ter no máximo 255 letras")
	@NotEmpty(message = "O nome da unidade de federação deve ser preenchido")
	private String nome;

	@Size(max = 2, message = "A sigla pode ter no máximo 2 letras")
	@NotEmpty(message = "A sigla da unidade de federação deve ser preenchido")
	private String sigla;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}