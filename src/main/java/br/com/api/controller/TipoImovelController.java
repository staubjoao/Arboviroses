package br.com.api.controller;

import br.com.api.model.TipoImovelModel;
import br.com.api.repository.TipoImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_imovel")
public class TipoImovelController {

    @Autowired
    private TipoImovelRepository repository;

    @GetMapping
    private List<TipoImovelModel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    private TipoImovelModel getTipoImovel(@PathVariable Integer id ) {
        return repository.findById(id).get();
    }

    @PostMapping
    private TipoImovelModel inserirTipoImovel(@RequestBody TipoImovelModel tipoImovelModel) {
        return repository.save(tipoImovelModel);
    }

    @PutMapping
    private TipoImovelModel alterarTipoImovel(@RequestBody TipoImovelModel tipoImovelModel) {
        return repository.save(tipoImovelModel);
    }

    @DeleteMapping("/{id}")
    private void deletarTipoImovel(@PathVariable Integer id) {
        TipoImovelModel tipoImovelModel = repository.findById(id).get();
        repository.delete(tipoImovelModel);
    }

}
