package com.join.tecnologia.case_join.service.impl;

import com.join.tecnologia.case_join.commons.BaseServiceImpl;
import com.join.tecnologia.case_join.exception.CategoriaInativaException;
import com.join.tecnologia.case_join.model.Categoria;
import com.join.tecnologia.case_join.model.Produto;
import com.join.tecnologia.case_join.repository.ProdutoRepository;
import com.join.tecnologia.case_join.service.CategoriaService;
import com.join.tecnologia.case_join.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends BaseServiceImpl<Produto, ProdutoRepository> implements ProdutoService {

    @Autowired
    private CategoriaService categoriaService;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        super(repository);
    }

    @Override
    public Produto salvar(Produto model) {
        if (model.getCategoriaId() != null) {
            Categoria categoria = categoriaService.procurarPorId(model.getCategoriaId());
            if (!categoria.isAtiva()) {
                throw new CategoriaInativaException("Categoria de ID: "+ model.getCategoriaId() + " está inativa");
            }
        }
        return super.salvar(model);
    }

    @Override
    public Produto editar(Produto model) {
        if (model.getCategoriaId() != null) {
            Categoria categoria = categoriaService.procurarPorId(model.getCategoriaId());
            if (!categoria.isAtiva()) {
                throw new CategoriaInativaException("Categoria de ID: "+ model.getCategoriaId() + " está inativa");
            }
        }
        return super.editar(model);
    }

}