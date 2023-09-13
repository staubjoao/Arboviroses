package br.com.api.controller;


import br.com.api.model.Bairro;
import br.com.api.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bairro")
public class BairroController {

    @Autowired
    private BairroRepository repository;

    @GetMapping
    private List<Bairro> getAll(){
        List<Bairro> bairros = repository.findAll();

        return repository.findAll();
    }

    @PostMapping
    private Bairro inserirBairro(@RequestBody Bairro bairro) {
        return repository.save(bairro);
    }

    @GetMapping("/{id}")
    private Bairro getBairro(@PathVariable Integer id) {
        return  repository.findById(id).get();
    }

    @PutMapping
    private Bairro alterarBairro(@RequestBody Bairro bairro) {
        return repository.save(bairro);
    }

    @DeleteMapping("/{id}")
    private void deleteBairro(@PathVariable Integer id) {
        Bairro bairro = repository.findById(id).get();
        repository.delete(bairro);
    }


}
