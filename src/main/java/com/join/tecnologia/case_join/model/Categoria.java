package com.join.tecnologia.case_join.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.join.tecnologia.case_join.commons.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Categoria extends BaseModel {

    @NotEmpty
    private String nome;

    private String descricao;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    private Integer indAtiva;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Produto> produtos;

    @Transient
    public boolean isAtiva() {
        return (indAtiva != null && indAtiva == 1);
    }

}