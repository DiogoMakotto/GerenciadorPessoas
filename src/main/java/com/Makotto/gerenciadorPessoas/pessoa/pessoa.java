package com.Makotto.gerenciadorPessoas.pessoa;

import java.time.LocalDate;

import com.Makotto.gerenciadorPessoas.endereco.endereco.Endereco;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;


	@Entity
	@Table(name = "pessoa")
	public class pessoa {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Nonnull //ou utilizando o "nullable = false" dentro da anotação @Column
	    @Column(name = "nome")
	    private String nome;

	    @Nonnull
	    @Column(name = "data_nascimento")
	    private LocalDate dataNascimento;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	    private Endereco endereco;

	    
	    // Getters and Setters
	    
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

		public LocalDate getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		
		//hashCode 
		
		@Override
		public int hashCode() {
			return getClass().hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			pessoa other = (pessoa) obj;
			return id == other.id;
		}

		 //toString
		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", endereco="
					+ endereco + "]";
		}
		    
	}

