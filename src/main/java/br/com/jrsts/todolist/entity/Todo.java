package br.com.jrsts.todolist.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Table(name="todos")
@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  private String descricao;

  @Builder.Default
  private boolean realizado = false;

  private int prioridade;

  public Todo (String nome, String descricao, Boolean realizado, int prioridade){
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
  }

  public Todo (){}

  public Long getId(){
    return id;
  }

  public String getDescricao(){
    return descricao;
  }

  public String getNome(){
    return nome;
  }
  
  public boolean getRealizado(){
    return realizado;
  }
  
  public int getPrioridade(){
    return prioridade;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }

  public void setRealizado(boolean realizado) {
    this.realizado = realizado;
  }
}