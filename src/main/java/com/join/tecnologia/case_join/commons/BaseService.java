package com.join.tecnologia.case_join.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T extends BaseModel> {

    T salvar(T model);

    T editar(T model);

    void deletar(Long id);

    T procurarPorId(Long id);

    Page<T> listarPaginado(Pageable pageable);

    List<T> listar();

}