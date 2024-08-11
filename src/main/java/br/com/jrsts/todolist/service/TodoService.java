package br.com.jrsts.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jrsts.todolist.dto.TodoDTO;
import br.com.jrsts.todolist.entity.Todo;
import br.com.jrsts.todolist.repository.TodoRepository;

@Service
public class TodoService {
  private TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }
   
  public Todo create(TodoDTO todoDTO) {
    Todo todo = new Todo(todoDTO.getNome(), todoDTO.getDescricao(), todoDTO.getRealizado(), todoDTO.getPrioridade());
    return todoRepository.save(todo);
  }

  public Optional<Todo> findOne(Long id) {
    return todoRepository.findById(id);
  }

  public List<Todo> list() {
    Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
    return todoRepository.findAll(sort);
  }

  public List<Todo> update(Todo todo) {
    todoRepository.save(todo);
    return list();
  }

  public List<Todo> delete(Long id) {
    todoRepository.deleteById(id);
    return list();
  }
 
}