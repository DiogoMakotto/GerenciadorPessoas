package br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.controllers;

import br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.endereco;
import org.springframework.web.bind.annotation.*;

public class pessoa {

    @RestController
    @RequestMapping("/pessoas")
    public class PessoaController {

        private final br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa.PessoaRepository pessoaRepository;
        private final endereco.Endereco.EnderecoRepository enderecoRepository;

        public PessoaController(br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa.PessoaRepository pessoaRepository, endereco.Endereco.EnderecoRepository enderecoRepository) {
            this.pessoaRepository = pessoaRepository;
            this.enderecoRepository = enderecoRepository;
        }

        @PostMapping
        public br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa createPessoa(@RequestBody br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa pessoa) {
            return pessoaRepository.save(pessoa);
        }

        @PutMapping("/{id}")
        public br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa updatePessoa(@PathVariable Long id, @RequestBody br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa pessoa) {
            br.com.ProjetoDiogoMakotto.Gerenciador.Pessoas.models.pessoa.Pessoa existingPessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
            existingPessoa.setNome(pessoa.getNome());
            existingPessoa.setDataNascimento(pessoa.getDataNascimento());
            return pessoaRepository.save(existingPessoa);
        }

        @GetMapping("/{id}")
        public Pessoa getPessoa(@PathVariable Long id) {
            return pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        }

        @GetMapping
        public List<Pessoa> listPessoas() {
            return pessoaRepository.findAll();
        }
    }
}
