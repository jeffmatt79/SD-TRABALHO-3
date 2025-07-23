package com.exemplo.supermercado.model;

public class Funcionario {
    protected String nome;
    protected int id;
    protected String tipo;

    public Funcionario() {}

    public Funcionario(String nome, int id, String tipo) {
        this.nome = nome;
        this.id = id;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

