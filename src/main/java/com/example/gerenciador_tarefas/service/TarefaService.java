package com.example.gerenciador_tarefas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gerenciador_tarefas.model.entity.Tarefa;
import com.example.gerenciador_tarefas.repository.TarefaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
}
