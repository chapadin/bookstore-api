package com.victor.bookstoreapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TITULO deve ter entre 3 e 50 caracteres")
    private String titulo;
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
    private String nomeAutor;
    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10, max = 200, message = "O campo TEXTO deve ter entre 10 e 200 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {

    }
}
