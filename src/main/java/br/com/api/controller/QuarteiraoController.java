package br.com.api.controller;


import br.com.api.model.QuarteiraoModel;
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
    private List<QuarteiraoModel> getAll() {
        return quarteiraoRepository.findAll();
    }

    @PostMapping
    private QuarteiraoModel inserirQuarteirao(@RequestBody QuarteiraoModel quarteiraoModel) {
        return quarteiraoRepository.save(quarteiraoModel);
    }

    @GetMapping("/{id}")
    private QuarteiraoModel getQuarteirao(@PathVariable Integer id) {
        return quarteiraoRepository.findById(id).get();
    }

    @PutMapping
    private QuarteiraoModel alterarQuarteirao(@RequestBody QuarteiraoModel quarteiraoModel) {
        return quarteiraoRepository.save(quarteiraoModel);
    }

    @DeleteMapping("/{id}")
    private void deletarQuarteirao(@PathVariable Integer id) {
        QuarteiraoModel quarteiraoModel = quarteiraoRepository.findById(id).get();
        quarteiraoRepository.delete(quarteiraoModel);
    }
}
