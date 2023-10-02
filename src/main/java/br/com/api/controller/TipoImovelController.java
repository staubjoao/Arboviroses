package br.com.api.controller;

import br.com.api.model.TipoImovel;
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
    private List<TipoImovel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    private TipoImovel getTipoImovel(@PathVariable Integer id ) {
        return repository.findById(id).get();
    }

    @PostMapping
    private TipoImovel inserirTipoImovel(@RequestBody TipoImovel tipoImovelModel) {
        return repository.save(tipoImovelModel);
    }

    @PutMapping
    private TipoImovel alterarTipoImovel(@RequestBody TipoImovel tipoImovelModel) {
        return repository.save(tipoImovelModel);
    }

    @DeleteMapping("/{id}")
    private void deletarTipoImovel(@PathVariable Integer id) {
        TipoImovel tipoImovelModel = repository.findById(id).get();
        repository.delete(tipoImovelModel);
    }

}
