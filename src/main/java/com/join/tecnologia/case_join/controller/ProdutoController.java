package com.join.tecnologia.case_join.controller;

import com.join.tecnologia.case_join.commons.BaseController;
import com.join.tecnologia.case_join.model.Produto;
import com.join.tecnologia.case_join.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping(value = "/api/produto")
@CrossOrigin(origins = "*")
@Slf4j
public class ProdutoController extends BaseController<Produto, ProdutoService> {

    public ProdutoController(ProdutoService service) {
        super(service);
    }

}