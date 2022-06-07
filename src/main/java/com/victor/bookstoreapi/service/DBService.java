package com.victor.bookstoreapi.service;

import com.victor.bookstoreapi.model.Categoria;
import com.victor.bookstoreapi.model.Livro;
import com.victor.bookstoreapi.repository.CategoriaRepository;
import com.victor.bookstoreapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Português", "Livros de Gramatica");
        Categoria cat3 = new Categoria(null, "Direito", "Livros de Direito");

        Livro liv1 = new Livro(null, "Clean code", "Robert Martin", "Loren Ipsum", cat1);
        Livro liv2 = new Livro(null, "Spring Framework", "Loiane Groner", "Loren Ipsum", cat1);
        Livro liv3 = new Livro(null, "Angular", "Loiane Groner", "Loren Ipsum", cat1);
        Livro liv4 = new Livro(null, "Gramatica", "Robert Martin", "Loren Ipsum", cat2);
        Livro liv5 = new Livro(null, "Direito Constitucional", "Robert Martin", "Loren Ipsum", cat3);
        Livro liv6 = new Livro(null, "Dureito Adminsitrativo", "Robert Martin", "Loren Ipsum", cat3);
        cat1.getLivros().addAll(Arrays.asList(liv1, liv2, liv3));
        cat2.getLivros().addAll(Arrays.asList(liv4));
        cat3.getLivros().addAll(Arrays.asList(liv5, liv6));
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4, liv5, liv6));
    }
}
