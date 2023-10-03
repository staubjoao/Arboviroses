package br.com.api.services;

import org.springframework.stereotype.Service;

import br.com.api.model.Bairro;

import java.util.List;

@Service
public interface BairroService {

    public Bairro save(Bairro bairro);
    public List<Bairro> getAll();
    public Bairro getById(Integer id);
    public void delete(Bairro bairro);


}