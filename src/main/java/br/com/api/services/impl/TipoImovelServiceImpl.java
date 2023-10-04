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
    private TipoImovelRepository tipoImovelRepository;

    @Override
    public TipoImovel save(TipoImovel tipoImovel) {
        return tipoImovelRepository.save(tipoImovel);
    }

    @Override
    public List<TipoImovel> getAll() {
        return tipoImovelRepository.findAll();
    }

    @Override
    public TipoImovel getById(Integer id) {
        return tipoImovelRepository.findById(id).get();
    }

    @Override
    public void delete(TipoImovel tipoImovel) {
        tipoImovelRepository.delete(tipoImovel);
    }

}
