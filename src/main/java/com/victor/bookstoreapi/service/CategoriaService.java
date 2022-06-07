package com.victor.bookstoreapi.service;

import com.victor.bookstoreapi.dto.CategoriaDTO;
import com.victor.bookstoreapi.model.Categoria;
import com.victor.bookstoreapi.repository.CategoriaRepository;
import com.victor.bookstoreapi.service.exceptions.DataIntegrityViolationException;
import com.victor.bookstoreapi.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(long id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return categoriaRepository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletado! Possui livros associados!");
        }
    }
}
