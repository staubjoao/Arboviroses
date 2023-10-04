package br.com.api.services.impl;

import br.com.api.model.Quarteirao;
import br.com.api.repository.QuarteiraoRepository;
import br.com.api.services.QuarteiraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QuarteiraoServiceImpl implements QuarteiraoService {
    @Autowired
    QuarteiraoRepository quarteiraoRepository;
    @Override
    public Quarteirao save(Quarteirao quarteirao) {
        return quarteiraoRepository.save(quarteirao);
    }

    @Override
    public List<Quarteirao> getAll() {
        return quarteiraoRepository.findAll();
    }

    @Override
    public Quarteirao getById(int id) {
        return quarteiraoRepository.findById(id).get();
    }

    @Override
    public void delete(Quarteirao quarteirao) {
        quarteiraoRepository.delete(quarteirao);
    }
}