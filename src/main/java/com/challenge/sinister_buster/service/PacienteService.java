package com.challenge.sinister_buster.service;

import com.challenge.sinister_buster.dto.PacienteRequest;
import com.challenge.sinister_buster.model.Paciente;
import com.challenge.sinister_buster.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
}
