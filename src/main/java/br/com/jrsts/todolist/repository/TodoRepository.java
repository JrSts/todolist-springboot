package br.com.jrsts.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jrsts.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
