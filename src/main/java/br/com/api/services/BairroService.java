package br.com.api.services;

import org.springframework.stereotype.Service;

import br.com.api.model.BairroModel;

import java.util.List;

@Service
public interface BairroService {

    public BairroModel save(BairroModel bairro);
    public List<BairroModel> getAll();
    public BairroModel getById(Integer id);
    public void delete(BairroModel bairro);
}