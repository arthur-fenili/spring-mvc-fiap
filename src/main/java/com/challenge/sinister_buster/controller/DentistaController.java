package com.challenge.sinister_buster.controller;

import com.challenge.sinister_buster.dto.DentistaRequest;
import com.challenge.sinister_buster.messaging.MessagingService;
import com.challenge.sinister_buster.model.Especialidade;
import com.challenge.sinister_buster.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
@Controller
@RequestMapping("/dentista")
public class DentistaController {

    private final DentistaService dentistaService;
    @Autowired
    private MessagingService messagingService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarDentista(DentistaRequest dentistaRequest) {
        try {
            dentistaService.cadastrarDentista(dentistaRequest);
            return new ModelAndView("redirect:/dentista/lista");
        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView mv = new ModelAndView("cadastroDentista");
            mv.addObject("erro", "Erro ao cadastrar dentista: " + e.getMessage());
            return mv;
        }
    }

    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView mv = new ModelAndView("cadastroDentista");
        mv.addObject("dentistaRequest", new DentistaRequest());
        mv.addObject("especialidades", Especialidade.values());
        return mv;
    }


    @GetMapping("/lista")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ModelAndView listaDentistas() {
        ModelAndView mv = new ModelAndView("listaDentistas");
        mv.addObject("dentistas", dentistaService.listarDentistas());
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarDentista(@PathVariable Long id) {
        dentistaService.deletarDentista(id);
        return new ModelAndView("redirect:/dentista/lista");
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editarDentista");
        mv.addObject("dentistaRequest", dentistaService.buscarPorId(id));
        mv.addObject("especialidades", Especialidade.values());
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizarDentista(@PathVariable Long id, DentistaRequest dentistaRequest) {
        dentistaService.atualizarDentista(id, dentistaRequest);
        return new ModelAndView("redirect:/dentista/lista");
    }

    @PostMapping("/enviar-mensagem")
    public ModelAndView sendTestMessage() {
        messagingService.sendMessage("Teste em " + LocalDateTime.now());
        return new ModelAndView("redirect:/dentista/lista");
    }
}
