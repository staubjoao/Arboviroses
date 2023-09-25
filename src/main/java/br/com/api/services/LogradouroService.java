package br.com.api.services;

import br.com.api.model.BairroModel;
import br.com.api.model.LogradouroModel;
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
    public LogradouroModel save(LogradouroModel logradouroModel){
        return  logradouroRepository.save(logradouroModel);
    }
    public List<LogradouroModel> getAll() {
        return logradouroRepository.findAll();
    }

    public Optional<LogradouroModel> buscaId(int id) {
        return logradouroRepository.findById(id);
    }
    @Transactional
    public void delete(LogradouroModel logradouroModel) {
        logradouroRepository.delete(logradouroModel);
    }
}
