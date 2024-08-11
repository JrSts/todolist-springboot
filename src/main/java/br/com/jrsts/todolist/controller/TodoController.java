package br.com.jrsts.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jrsts.todolist.dto.TodoDTO;
import br.com.jrsts.todolist.entity.Todo;
import br.com.jrsts.todolist.service.TodoService;


@RestController
@RequestMapping("/todos")
public class TodoController {
  private TodoService todoService;

  public TodoController (TodoService todoService) {
    this.todoService = todoService;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @PostMapping
  ResponseEntity<Todo> create(@RequestBody TodoDTO todoDTO) {
    return new ResponseEntity(todoService.create(todoDTO), HttpStatus.CREATED);
  }

  @GetMapping
  ResponseEntity<List<Todo>> list() {
    return ResponseEntity.ok().body(todoService.list());
  }

  @GetMapping("/{id}")
  ResponseEntity<Optional<Todo>> findOne(@PathVariable Long id) {
    return ResponseEntity.ok().body(todoService.findOne(id));
  }

  @PutMapping("/{id}")
  ResponseEntity<Todo> update(@RequestBody TodoDTO todoDTO, @PathVariable Long id) {
    return ResponseEntity.ok().body(todoService.update(todoDTO, id));
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Todo> delete(@PathVariable Long id) {
    todoService.delete(id);
    return ResponseEntity.noContent().build();
  }
}