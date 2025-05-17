package com.challenge.sinister_buster.controller;

import com.challenge.sinister_buster.dto.PacienteRequest;
import com.challenge.sinister_buster.service.PacienteService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/cadastrar")
    public ModelAndView formularioCadastro() {
        ModelAndView mv = new ModelAndView("cadastroPaciente"); // Nome do arquivo HTML
        mv.addObject("pacienteRequest", new PacienteRequest()); // Passa um objeto vazio para o formulário
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarPaciente(@ModelAttribute PacienteRequest pacienteRequest) {
        pacienteService.cadastrarPaciente(pacienteRequest);
        return new ModelAndView("redirect:/paciente/lista");
    }

    @GetMapping("/lista")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView listaPacientes() {
        ModelAndView mv = new ModelAndView("listaPacientes");
        mv.addObject("pacientes", pacienteService.listarPacientes());
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return new ModelAndView("redirect:/paciente/lista");
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editarPaciente");
        mv.addObject("pacienteRequest", pacienteService.buscarPorId(id));
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizarPaciente(@PathVariable Long id, PacienteRequest pacienteRequest) {
        pacienteService.atualizarPaciente(id, pacienteRequest);
        return new ModelAndView("redirect:/paciente/lista");
    }

}
