package com.join.tecnologia.case_join.controller;

import com.join.tecnologia.case_join.commons.BaseController;
import com.join.tecnologia.case_join.model.Categoria;
import com.join.tecnologia.case_join.service.CategoriaService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/api/categorias")
@CrossOrigin(origins = "*")
@Slf4j
public class CategoriaController extends BaseController<Categoria, CategoriaService> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }

}