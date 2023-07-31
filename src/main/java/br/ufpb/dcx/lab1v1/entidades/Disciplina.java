package br.ufpb.dcx.lab1v1.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Disciplina {

    private static int proximoID = 1;
    private int id;
    private String nome;
    private int likes;
    private List<Double> notas = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
        this.id = proximoID++;
    }

    public long getId() {
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

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
