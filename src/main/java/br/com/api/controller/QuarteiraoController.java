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
    private Quarteirao inserirQuarteirao(@RequestBody Quarteirao quarteirao) {
        return quarteiraoRepository.save(quarteirao);
    }

    @GetMapping("/{id}")
    private Quarteirao getQuarteirao(@PathVariable Integer id) {
        return quarteiraoRepository.findById(id).get();
    }

    @PutMapping
    private Quarteirao alterarQuarteirao(@RequestBody Quarteirao quarteirao) {
        return quarteiraoRepository.save(quarteirao);
    }

    @DeleteMapping("/{id}")
    private void deletarQuarteirao(@PathVariable Integer id) {
        Quarteirao quarteirao = quarteiraoRepository.findById(id).get();
        quarteiraoRepository.delete(quarteirao);
    }
}
