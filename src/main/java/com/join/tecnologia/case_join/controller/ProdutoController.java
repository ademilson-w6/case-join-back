package com.join.tecnologia.case_join.controller;

import com.join.tecnologia.case_join.commons.BaseController;
import com.join.tecnologia.case_join.model.Produto;
import com.join.tecnologia.case_join.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@Tag(name = "Produtos")
@RestController
@RequestMapping(value = "/api/produtos")
@CrossOrigin(origins = "*")
@Slf4j
public class ProdutoController extends BaseController<Produto, ProdutoService> {

    public ProdutoController(ProdutoService service) {
        super(service);
    }

}