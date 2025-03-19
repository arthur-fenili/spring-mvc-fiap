package com.challenge.sinister_buster.service;

import com.challenge.sinister_buster.dto.DentistaRequest;
import com.challenge.sinister_buster.model.Dentista;
import com.challenge.sinister_buster.repository.DentistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    private final DentistaRepository dentistaRepository;

    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    public void cadastrarDentista(DentistaRequest dentistaRequest) {
        Dentista dentista = new Dentista();
        BeanUtils.copyProperties(dentistaRequest, dentista);
        dentistaRepository.save(dentista);
    }

    public void deletarDentista(Long id) {
        Optional<Dentista> optionalDentista = dentistaRepository.findById(id);
        if(optionalDentista.isPresent()){
            dentistaRepository.delete(optionalDentista.get());
        } else {
            throw new RuntimeException("Dentista não encontrado");
        }
    }

    public List<Dentista> listarDentistas() {
        return Optional.of(dentistaRepository.findAll()).orElse(Collections.emptyList());
    }

    public void atualizarDentista(DentistaRequest dentistaRequest) {
        Optional<Dentista> optionalDentista = dentistaRepository.findById(dentistaRequest.getId());
        if(optionalDentista.isPresent()){
            Dentista dentistaExistente = optionalDentista.get();
            BeanUtils.copyProperties(dentistaRequest, dentistaExistente, "id");
            dentistaRepository.save(dentistaExistente);
        } else {
            throw new RuntimeException("Dentista não encontrado");
        }
    }
}
