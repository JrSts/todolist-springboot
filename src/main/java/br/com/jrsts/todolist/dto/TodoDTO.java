package br.com.jrsts.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

/**
 * Todo.dto
 */

 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
public class TodoDTO{
    @NotBlank
    private String nome;
    private String descricao;
    @Default
    private boolean realizado = false;
    private int prioridade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean getRealizado() {
        return realizado;
    }
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}