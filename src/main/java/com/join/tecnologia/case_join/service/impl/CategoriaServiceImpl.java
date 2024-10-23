package com.join.tecnologia.case_join.service.impl;

import com.join.tecnologia.case_join.commons.BaseServiceImpl;
import com.join.tecnologia.case_join.model.Categoria;
import com.join.tecnologia.case_join.repository.CategoriaRepository;
import com.join.tecnologia.case_join.service.CategoriaService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, CategoriaRepository> implements CategoriaService {

    public CategoriaServiceImpl(CategoriaRepository repository) {
        super(repository);
    }

}