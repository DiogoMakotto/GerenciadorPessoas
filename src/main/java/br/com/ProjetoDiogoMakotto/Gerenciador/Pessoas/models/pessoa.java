package br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public class pessoa {

    @Entity
    @Table(name = "pessoa")
    public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "nome")
        private String nome;

        @NotNull
        @Column(name = "data_nascimento")
        private LocalDate dataNascimento;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "endereco_id", referencedColumnName = "id")
        private br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco endereco;

        public void setId(Long id) {
            this.id = id;
        }

        @Id
        public Long getId() {
            return id;
        }

        // Getters and Setters

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

        public br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco getEndereco() {
            return endereco;
        }

        public void setEndereco(br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco endereco) {
            this.endereco = endereco;
        }

        public List<br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco> getEnderecos() {
        }

        @Repository // gerenciamento de operações
        public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
        }
    }
}
