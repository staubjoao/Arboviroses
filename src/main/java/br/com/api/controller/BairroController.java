package br.com.api.controller;


import br.com.api.model.Bairro;
import br.com.api.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bairro")
public class BairroController {

    @Autowired
    private BairroRepository repository;

    private List<Bairro> getAll(){
        return repository.findAll();
    }

}
