package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Localidade;
import br.com.api.repository.LocalidadeRepository;


@RestController
@RequestMapping("api/localidade")
public class LocalidadeController {
    
    @Autowired
    private LocalidadeRepository repository;

    @GetMapping
    public List<Localidade> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Localidade inserir(@RequestBody Localidade localidade) {
        return repository.save(localidade);
    }

    @PutMapping
    public Localidade alterar(@RequestBody Localidade localidade) {
        return repository.save(localidade);
    }

    @GetMapping("/{id}")
    private Localidade getById(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    private void deletar(@PathVariable Integer id)
    {
        Localidade obj = repository.findById(id).get();
        repository.delete(obj);
    }
}
