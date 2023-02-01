package br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public class endereco {

    @Entity
    @Table(name = "endereco")
    public static class Endereco {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "logradouro")
        private String logradouro;

        @NotNull
        @Column(name = "cep")
        private String cep;

        @NotNull
        @Column(name = "numero")
        private Integer numero;

        @NotNull
        @Column(name = "cidade")
        private String cidade;

        public void setId(Long id) {
            this.id = id;
        }

        @Id
        public Long getId() {
            return id;
        }

        // Getters and Setters

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

        @Repository  //Gerenciamento de operações
        public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
        }
    }
}
