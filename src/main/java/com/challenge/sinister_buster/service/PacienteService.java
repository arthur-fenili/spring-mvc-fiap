package com.challenge.sinister_buster.service;

import com.challenge.sinister_buster.dto.PacienteRequest;
import com.challenge.sinister_buster.model.Paciente;
import com.challenge.sinister_buster.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(PacienteRequest pacienteRequest) {
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteRequest, paciente);
        pacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);
        if(optionalPaciente.isPresent()){
            pacienteRepository.delete(optionalPaciente.get());
        } else {
            throw new RuntimeException("Paciente não encontrado");
        }
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public void atualizarPaciente(PacienteRequest pacienteRequest) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(pacienteRequest.getId());
        if(optionalPaciente.isPresent()){
            Paciente pacienteExistente = optionalPaciente.get();
            BeanUtils.copyProperties(pacienteRequest, pacienteExistente, "id");
            pacienteRepository.save(pacienteExistente);
        } else {
            throw new RuntimeException("Paciente não encontrado");
        }
    }
}
