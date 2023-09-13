package br.com.api.controller;

import br.com.api.model.Logradouro;
import br.com.api.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroRepository repository;

    @GetMapping
    private List<Logradouro> getAll() {
        return repository.findAll();
    }

    @PostMapping
    private Logradouro inserirLogradouro(@RequestBody Logradouro logradouro) {
        return repository.save(logradouro);
    }

    @GetMapping("/{id}")
    private Logradouro getLogradouro(@PathVariable Integer id) {
        return  repository.findById(id).get();
    }

    @PutMapping
    private Logradouro alterarLogradouro(@RequestBody Logradouro logradouro) {
        return repository.save(logradouro);
    }

    @DeleteMapping("/{id}")
    private void deleteLogradouro(@PathVariable Integer id) {
        Logradouro bairro = repository.findById(id).get();
        repository.delete(bairro);
    }
}
