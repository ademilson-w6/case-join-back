package com.join.tecnologia.case_join.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.join.tecnologia.case_join.commons.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Produto extends BaseModel {

    @NotEmpty
    private String nome;

    private String sku;

    private String descricao;

    @NotNull
    @Digits(integer = 13, fraction = 2)
    private BigDecimal valorUnitario;

    @Column(name = "category_id")
    private Long categoriaId;

    @ManyToOne(targetEntity = Categoria.class, fetch= FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName="id", nullable=false, insertable=false, updatable=false)
    @JsonBackReference
    private Categoria categoria;

}