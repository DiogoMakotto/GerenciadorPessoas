package br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.controllers;

import br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class endereco {

    @PostMapping("/{id}/enderecos")
    public br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco createEnderecoForPessoa(@PathVariable Long id, @RequestBody br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco endereco) {
        SimpleJpaRepository pessoaRepository = null;
        pessoa.Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);
    }

    @GetMapping("/{id}/enderecos")
    public List<br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco.Endereco> listEnderecosForPessoa(@PathVariable Long id) {
        pessoa.Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return pessoa.getEnderecos();
    }
}
