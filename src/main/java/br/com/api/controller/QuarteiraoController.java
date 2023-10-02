package br.com.api.controller;


import br.com.api.model.Quarteirao;
import br.com.api.repository.QuarteiraoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quarteirao")
public class QuarteiraoController {

    @Autowired
    private QuarteiraoRepository quarteiraoRepository;

    @GetMapping
    private List<Quarteirao> getAll() {
        return quarteiraoRepository.findAll();
    }

    @PostMapping
    private Quarteirao inserirQuarteirao(@RequestBody Quarteirao quarteiraoModel) {
        return quarteiraoRepository.save(quarteiraoModel);
    }

    @GetMapping("/{id}")
    private Quarteirao getQuarteirao(@PathVariable Integer id) {
        return quarteiraoRepository.findById(id).get();
    }

    @PutMapping
    private Quarteirao alterarQuarteirao(@RequestBody Quarteirao quarteiraoModel) {
        return quarteiraoRepository.save(quarteiraoModel);
    }

    @DeleteMapping("/{id}")
    private void deletarQuarteirao(@PathVariable Integer id) {
        Quarteirao quarteiraoModel = quarteiraoRepository.findById(id).get();
        quarteiraoRepository.delete(quarteiraoModel);
    }
}
