package br.com.api.controller;

import br.com.api.model.TipoImovelModel;
import br.com.api.repository.TipoImovelRepository;
import br.com.api.services.impl.TipoImovelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TipoImovelController {

    @Autowired
    private TipoImovelServiceImpl serviceTipoImovel;

    @PostMapping
    private TipoImovelModel inserirTipoImovel(@RequestBody TipoImovelModel tipoImovelModel) {
        return serviceTipoImovel.save(tipoImovelModel);
    }

    @GetMapping
    private List<TipoImovelModel> getAll() {
        return serviceTipoImovel.getAll();
    }

    @GetMapping("/{id}")
    private TipoImovelModel getTipoImovel(@PathVariable Integer id ) {
        return serviceTipoImovel.getById(id);
    }

    @PutMapping
    private TipoImovelModel alterarTipoImovel(@RequestBody TipoImovelModel tipoImovelModel) {
        return serviceTipoImovel.put(tipoImovelModel);
    }

    @DeleteMapping("/{id}")
    private void deletarTipoImovel(@PathVariable Integer id) {
        TipoImovelModel tipoImovelModel = serviceTipoImovel.getById(id);
        serviceTipoImovel.delete(tipoImovelModel);
    }

}
