package com.example.gerenciador_tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciador_tarefas.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
