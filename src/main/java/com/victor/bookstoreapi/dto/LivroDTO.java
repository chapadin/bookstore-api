package com.victor.bookstoreapi.dto;

import com.victor.bookstoreapi.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LivroDTO implements Serializable {

    private Long id;
    private String titulo;

    public LivroDTO(Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }
}
