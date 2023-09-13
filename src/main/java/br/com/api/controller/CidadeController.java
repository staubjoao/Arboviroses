package br.com.api.controller;

import br.com.api.model.Cidade;
import br.com.api.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    private List<Cidade> getAll() {
        return repository.findAll();
    }

    @PostMapping
    private Cidade inserirCidade(@RequestBody Cidade cidade) {
        return repository.save(cidade);
    }

    @GetMapping("/{id}")
    private Cidade getCidade(@PathVariable Integer id) {
        return  repository.findById(id).get();
    }

    @PutMapping
    private Cidade alterarCidade(@RequestBody Cidade cidade) {
        return repository.save(cidade);
    }

}
