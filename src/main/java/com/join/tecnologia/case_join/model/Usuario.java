package com.join.tecnologia.case_join.model;

import com.join.tecnologia.case_join.commons.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseModel {

    private String name;
    private String email;
    private String password;

}