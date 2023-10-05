package br.com.api.services.impl;

import br.com.api.model.Logradouro;
import br.com.api.repository.LogradouroRepository;
import br.com.api.services.LogradouroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogradouroServiceImpl implements LogradouroService {
    @Autowired
    LogradouroRepository logradouroRepository;
    @Override
    public Logradouro save(Logradouro logradouro) {
        return logradouroRepository.save(logradouro);
    }

    @Override
    public List<Logradouro> getAll() {
        return logradouroRepository.findAll();
    }

    @Override
    public Logradouro getById(int id) {
        return logradouroRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Logradouro logradouro) {
        logradouroRepository.delete(logradouro);
    }
}