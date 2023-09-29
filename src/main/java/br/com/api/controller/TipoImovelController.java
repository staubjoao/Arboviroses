package br.com.api.controller;

import br.com.api.model.TipoImovel;
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
    private TipoImovel inserirTipoImovel(@RequestBody TipoImovel tipoImovel) {
        return serviceTipoImovel.save(tipoImovel);
    }

    @GetMapping
    private List<TipoImovel> getAll() {
        return serviceTipoImovel.getAll();
    }

    @GetMapping("/{id}")
    private TipoImovel getTipoImovel(@PathVariable Integer id ) {
        return serviceTipoImovel.getById(id);
    }

    @PutMapping
    private TipoImovel alterarTipoImovel(@RequestBody TipoImovel tipoImovel) {
        return serviceTipoImovel.put(tipoImovel);
    }

    @DeleteMapping("/{id}")
    private void deletarTipoImovel(@PathVariable Integer id) {
        TipoImovel tipoImovel = serviceTipoImovel.getById(id);
        serviceTipoImovel.delete(tipoImovel);
    }

}
