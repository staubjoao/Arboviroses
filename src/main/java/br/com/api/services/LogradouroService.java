package br.com.api.services;

import br.com.api.model.Logradouro;
import br.com.api.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LogradouroService {
    @Autowired
    LogradouroRepository logradouroRepository;
    @Transactional
    public Logradouro save(Logradouro logradouro){
        return  logradouroRepository.save(logradouro);
    }
    public List<Logradouro> getAll() {
        return logradouroRepository.findAll();
    }

    public Optional<Logradouro> buscaId(int id) {
        return logradouroRepository.findById(id);
    }
    @Transactional
    public void delete(Logradouro logradouro) {
        logradouroRepository.delete(logradouro);
    }
}
