package com.join.tecnologia.case_join.commons;

import com.join.tecnologia.case_join.exception.EntidadeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class BaseServiceImpl<T extends BaseModel, K extends JpaRepository<T, Long>> implements BaseService<T> {

    protected final K repository;

    @SuppressWarnings("unchecked")
    protected Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void deletar(Long id) {
        verificar(id);
        repository.deleteById(id);
    }

    @Override
    public T salvar(T model) {
        return repository.save(model);
    }

    @Override
    public T procurarPorId(Long id) {
        verificar(id);
        return repository.getById(id);
    }

    @Override
    public Page<T> listarPaginado(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<T> listar() {
        return this.repository.findAll();
    }

    @Override
    public T editar(T entidade) {
        verificar(entidade.getId());
        return repository.save(entidade);
    }

    protected void verificar(Long id) {
        if (repository.findById(id).isEmpty()) {
            String entityName = getEntityClass().getSimpleName();
            log.error("Não foi encontrada a entidade com o ID: " + id + " para a classe: " + entityName);
            throw new EntidadeException("Não foi encontrada a entidade: " + entityName + " com o ID: " + id);
        }
    }

}