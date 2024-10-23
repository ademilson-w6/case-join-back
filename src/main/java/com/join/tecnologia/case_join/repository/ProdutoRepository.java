package com.join.tecnologia.case_join.repository;

import com.join.tecnologia.case_join.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}