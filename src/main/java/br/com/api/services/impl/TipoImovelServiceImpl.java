package br.com.api.services.impl;

import br.com.api.model.TipoImovel;
import br.com.api.repository.TipoImovelRepository;
import br.com.api.services.TipoImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoImovelServiceImpl implements TipoImovelService {

    @Autowired
    private TipoImovelRepository repository;

    @Override
    public TipoImovel save(TipoImovel tipoImovel) {
        return repository.save(tipoImovel);
    }

    @Override
    public List<TipoImovel> getAll() {
        return repository.findAll();
    }

    @Override
    public TipoImovel getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(TipoImovel tipoImovel) {
        repository.delete(tipoImovel);
    }

}
