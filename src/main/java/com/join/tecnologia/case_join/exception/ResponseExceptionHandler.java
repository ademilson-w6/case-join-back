package com.join.tecnologia.case_join.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntidadeException.class})
    protected ResponseEntity<Object> entidadeNaoEncontrada(
            EntidadeException ex, WebRequest request) {
        log.error("Erro de entidade: {}", ex.getMessage());
        return handleExceptionInternal(ex, ErrorResponse.builder().message(ex.getMessage()).build(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<Object> erroValidacao(
            ConstraintViolationException ex, WebRequest request) {
        String message = ex.getConstraintViolations().stream().map(violation -> String.format("%s: %s", violation.getPropertyPath(), violation.getMessage())).collect(Collectors.joining(", "));
        log.error("Erro de validação encontrado: {}", message);
        return handleExceptionInternal(ex, ErrorResponse.builder().message(message).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {CategoriaInativaException.class})
    protected ResponseEntity<Object> categoriaInativa(
            CategoriaInativaException ex, WebRequest request) {
        log.error("Erro de categoria inativa: {}", ex.getMessage());
        return handleExceptionInternal(ex, ErrorResponse.builder().message(ex.getMessage()).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {CategoriaComProdutoException.class})
    protected ResponseEntity<Object> categoriaComProduto(
            CategoriaComProdutoException ex, WebRequest request) {
        log.error("Erro ao deletar categoria: {}", ex.getMessage());
        return handleExceptionInternal(ex, ErrorResponse.builder().message(ex.getMessage()).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}