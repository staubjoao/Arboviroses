package br.com.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.api.model.Bairro;
import br.com.api.repository.BairroRepository;
import br.com.api.services.BairroService;

import java.util.List;

@Component
public class BairroServiceImpl implements BairroService {

    @Autowired
    private BairroRepository repository;

    @Override
    public Bairro save(Bairro bairro) {
        return repository.save(bairro);
    }

    @Override
    public List<Bairro> getAll() {
        return repository.findAll();
    }

    @Override
    public Bairro getById(Integer id)
    {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Bairro bairro) {
        repository.delete(bairro);
    }

}
