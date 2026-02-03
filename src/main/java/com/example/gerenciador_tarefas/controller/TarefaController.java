package com.example.gerenciador_tarefas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciador_tarefas.model.entity.Tarefa;
import com.example.gerenciador_tarefas.service.TarefaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService tarefaService;

    @GetMapping("/{id}")
    public Tarefa buscarPorID(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }
    
    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }
    
}
