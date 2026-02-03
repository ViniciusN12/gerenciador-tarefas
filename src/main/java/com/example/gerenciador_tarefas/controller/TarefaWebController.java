package com.example.gerenciador_tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.gerenciador_tarefas.model.entity.Tarefa;
import com.example.gerenciador_tarefas.service.TarefaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    public String salvarTarefa(Tarefa tarefa) {
        tarefaService.save(tarefa);
        return "redirect:/";
    }

    @GetMapping("/tarefas/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        tarefaService.deletar(tarefa);
        return "redirect:/";
    }

    @GetMapping("/tarefas/atualizar/{id}")
    public String atualizarTarefaForm(@PathVariable Long id, Model model) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        model.addAttribute("tarefa", tarefa);
        return "updateTarefa";
    }

    @PostMapping("/tarefas/atualizar/{id}")
    public String atualizarTarefa(@PathVariable Long id, Tarefa tarefaDetails) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        tarefa.setTitulo(tarefaDetails.getTitulo());
        tarefa.setStatus(tarefaDetails.getStatus());
        tarefaService.save(tarefa);
        return "redirect:/";
    }
}