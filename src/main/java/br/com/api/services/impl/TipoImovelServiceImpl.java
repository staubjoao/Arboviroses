package br.com.api.services.impl;

import br.com.api.model.TipoImovelModel;
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
    public TipoImovelModel save(TipoImovelModel tipoImovelModel) {
        return tipoImovelRepository.save(tipoImovelModel);
    }

    @Override
    public List<TipoImovelModel> getAll() {
        return tipoImovelRepository.findAll();
    }

    @Override
    public TipoImovelModel getById(Integer id) {
        return tipoImovelRepository.findById(id).get();
    }

    @Override
    public void delete(TipoImovelModel tipoImovelModel) {
        tipoImovelRepository.delete(tipoImovelModel);
    }

    @Override
    public TipoImovelModel put(TipoImovelModel tipoImovelModel) {
        return tipoImovelRepository.save(tipoImovelModel);
    }
}
