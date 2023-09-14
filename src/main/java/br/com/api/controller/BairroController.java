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
    private BairroRepository bairroRepository;

    @GetMapping
    private List<Bairro> getAll(){
        return bairroRepository.findAll();
    }

    @PostMapping
    private Bairro inserirBairro(@RequestBody Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    @GetMapping("/{id}")
    private Bairro getBairro(@PathVariable Integer id) {
        return  bairroRepository.findById(id).get();
    }

    @PutMapping
    private Bairro alterarBairro(@RequestBody Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    @DeleteMapping("/{id}")
    private void deleteBairro(@PathVariable Integer id) {
        Bairro bairro = bairroRepository.findById(id).get();
        bairroRepository.delete(bairro);
    }

}
