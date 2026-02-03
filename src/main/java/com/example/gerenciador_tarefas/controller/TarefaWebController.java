package com.example.gerenciador_tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.gerenciador_tarefas.service.TarefaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class TarefaWebController {
    private final TarefaService tarefaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tarefas", tarefaService.listarTodas());
        return "index";
    }
    
    @GetMapping("/tarefas/criar")
    public String criarTarefaForm() {
        return "createTarefa";
    }

    @PostMapping("/tarefas/salvar")
    public String salvarTarefa(com.example.gerenciador_tarefas.model.entity.Tarefa tarefa) {
        tarefaService.save(tarefa);
        return "redirect:/";
    }
}
