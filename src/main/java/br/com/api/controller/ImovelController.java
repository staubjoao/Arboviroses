package br.com.api.controller;

import br.com.api.dtos.ImovelDTO;
import br.com.api.model.*;
import br.com.api.repository.*;
import br.com.api.services.TipoImovelService;
import br.com.api.services.impl.ImovelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl imovelService;

    @PostMapping
    private Imovel inserirImovel(@RequestBody Imovel imovel) {
        return imovelService.save(imovel);
    }

    @GetMapping
    private List<Imovel> getAll() {
        return imovelService.getAll();
    }

    @GetMapping("/{id}")
    private Imovel getImovel(@PathVariable Integer id) {
        return imovelService.getById(id);
    }

    @PutMapping
    private Imovel getImovel(@RequestBody Imovel imovel) {
        // depois vou tratar melhor isso
        return imovelService.put(imovel);
    }

    @DeleteMapping("/{id}")
    private void deletarImovel(@PathVariable Integer id) {
        Imovel imovel = imovelService.getById(id);
        imovelService.delete(imovel);
    }
}
