package br.com.global.apitechsolutions.service;

import br.com.global.apitechsolutions.model.Tarefa;
import br.com.global.apitechsolutions.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listar() { return tarefaRepository.findAll(); }

    public Optional<Tarefa> buscar(Long id) { return tarefaRepository.findById(id); }

    public Tarefa cadastrar(Tarefa tarefa) { return tarefaRepository.save(tarefa); }

    public Optional<Tarefa> atualizar(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setPrioridade(tarefaAtualizada.getPrioridade());
            return tarefaRepository.save(tarefaExistente);
        });
    }

    public void remover(Long id) { tarefaRepository.deleteById(id); }
}
