package com.join.tecnologia.case_join.commons;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;

@Slf4j
@RequiredArgsConstructor
public class BaseController<K extends BaseModel, T extends BaseService<K>> {

    protected final T service;

    @GetMapping
    public Page<K> getAll(HttpServletRequest request, Pageable pageable) {
        log.info("Buscando todos os {}", getGenericName());
        return service.listarPaginado(pageable);
    }

    @PostMapping
    public K save(@RequestBody K model) {
        log.info("Salvando {} pelo ID: {}", getGenericName(), model);
        return service.salvar(model);
    }

    @GetMapping("/{id}")
    public K getById(@PathVariable Long id) {
        log.info("Buscando {} pelo ID {}", getGenericName(), id);
        return service.procurarPorId(id);
    }

    @PutMapping("/{id}")
    public K edit(@PathVariable Long id, @RequestBody K model) {
        log.info("Editando o {}", getGenericName());
        model.setId(id);
        return service.editar(model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Deletando {} pelo ID: {}", getGenericName(), id);
        service.deletar(id);
    }

    protected String getGenericName() {
        return ((Class<K>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }

}