package com.join.tecnologia.case_join.commons;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private Long id;

    @Column(name = "criado_por", updatable = false)
    @CreatedBy
    private String criadoPor;

    @Column(name = "atualizado_por")
    @LastModifiedBy
    private String atualizadoPor;

    @CreatedDate
    @Column(name = "criado_em", nullable = false, updatable = false)
    private Date criadoEm;

    @LastModifiedDate
    @Column(name = "atualizado_em", nullable = false)
    private Date atualizadoEm;

}