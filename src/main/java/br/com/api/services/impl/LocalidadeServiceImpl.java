package br.com.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.model.Localidade;
import br.com.api.repository.LocalidadeRepository;
import br.com.api.services.LocalidadeService;

import java.util.List;

@Component
public class LocalidadeServiceImpl implements LocalidadeService{
    
    @Autowired
    private LocalidadeRepository repository;

    @Override
    public Localidade save(Localidade localidade) {
        return repository.save(localidade);
    }

    @Override
    public List<Localidade> getAll() {
        return repository.findAll();
    }

    @Override
    public Localidade getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Localidade localidade)
    {
        repository.delete(localidade);
    }


}
