package com.Makotto.gerenciadorPessoas.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa")
public interface pessoaRepositorio extends JpaRepository<pessoa, Long>{
}
