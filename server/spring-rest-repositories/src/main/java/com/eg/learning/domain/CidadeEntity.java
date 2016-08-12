package com.eg.learning.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Strings;

@Entity(name = CidadeEntity.NAME)
@Table(name = CidadeEntity.NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2904014162617986581L;
	public static final String NAME = "Cidade";
	private static final String SEQUENCE = "S_CIDADE";

	@Id
	@GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = SEQUENCE, name = SEQUENCE, allocationSize = 1)
	private Long id;

	@NotEmpty(message = "O nome da cidade deve ser preenchido")
	private String nome;

	@Pattern(regexp = "^[0-9]")
	private String codigoIbge;

	@NotNull(message = "A UF da cidade deve ser preenchida")
	@ManyToOne(optional = false)
	@JoinColumn(name = "uf_id")
	private UfEntity uf;

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return Strings.nullToEmpty(nome).toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoIbge() {
		return Strings.nullToEmpty(codigoIbge);
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public UfEntity getUf() {
		return uf;
	}

	public void setUf(UfEntity uf) {
		this.uf = uf;
	}

	public void setId(Long id) {
		this.id = id;
	}
}