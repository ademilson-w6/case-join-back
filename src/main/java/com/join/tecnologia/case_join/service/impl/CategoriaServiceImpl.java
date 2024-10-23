package com.join.tecnologia.case_join.service.impl;

import com.join.tecnologia.case_join.commons.BaseServiceImpl;
import com.join.tecnologia.case_join.exception.CategoriaComProdutoException;
import com.join.tecnologia.case_join.model.Categoria;
import com.join.tecnologia.case_join.repository.CategoriaRepository;
import com.join.tecnologia.case_join.repository.ProdutoRepository;
import com.join.tecnologia.case_join.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, CategoriaRepository> implements CategoriaService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        super(repository);
    }

    @Override
    public void deletar(Long id) {
        if (produtoRepository.existsByCategoriaId(id)) {
            throw new CategoriaComProdutoException("Categoria está relacionada com Produto");
        }
        super.deletar(id);
    }

}