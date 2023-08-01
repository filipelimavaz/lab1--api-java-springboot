package br.ufpb.dcx.lab1v1.dtos;

import java.util.List;

public class DisciplinaDTO {

    private static int proximoID = 1;
    private int id;
    private String nome;
    private int likes;
    private Double nota;
    private List<Double> notas;

    public DisciplinaDTO(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Double getNota() {
        return nota;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
