package com.Makotto.gerenciadorPessoas.endereco;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public interface endereco {

	@Entity
	@Table(name = "endereco")
	public class Endereco {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Nonnull
	    @Column(name = "logradouro")
	    private String logradouro;

	    @Nonnull
	    @Column(name = "cep")
	    private String cep;

	    @Nonnull
	    @Column(name = "numero")
	    private Integer numero;

	    @Nonnull
	    @Column(name = "cidade")
	    private String cidade;

	    // Getters and Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public Integer getNumero() {
			return numero;
		}

		public void setNumero(Integer numero) {
			this.numero = numero;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
    
	}
}
