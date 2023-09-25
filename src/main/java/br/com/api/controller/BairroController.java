package br.com.api.controller;


import br.com.api.model.BairroModel;
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
    private List<BairroModel> getAll(){
        return bairroRepository.findAll();
    }

    @PostMapping
    private BairroModel inserirBairro(@RequestBody BairroModel bairroModel) {
        return bairroRepository.save(bairroModel);
    }

    @GetMapping("/{id}")
    private BairroModel getBairro(@PathVariable Integer id) {
        return  bairroRepository.findById(id).get();
    }

    @PutMapping
    private BairroModel alterarBairro(@RequestBody BairroModel bairroModel) {
        return bairroRepository.save(bairroModel);
    }

    @DeleteMapping("/{id}")
    private void deleteBairro(@PathVariable Integer id) {
        BairroModel bairroModel = bairroRepository.findById(id).get();
        bairroRepository.delete(bairroModel);
    }

}
