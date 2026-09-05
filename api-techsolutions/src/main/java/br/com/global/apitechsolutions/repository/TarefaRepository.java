package br.com.global.apitechsolutions.repository;

import br.com.global.apitechsolutions.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
