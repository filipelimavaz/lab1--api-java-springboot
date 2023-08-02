package br.ufpb.dcx.lab1v1.entidades;

import java.util.ArrayList;
import java.util.List;

public class Disciplina{

    private static long proximoID = 1;
    private Long id;
    private String nome;
    private int likes;
    private Double nota;
    private List<Double> notas = new ArrayList<>();

    public Disciplina(String nome) {
        this.nome = nome;
        this.id = proximoID++;
    }

    public Long getId() {
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

    public Double getNota() {
        return nota;
    }

    public void adicionarNota(Double nota) {
        notas.add(nota);
    }
    public void removerNota() {
        notas.clear();
    }

    public void adicionaLike() {
        this.likes += 1;
    }

    private Double geraMediaNotas(List<Double> notas) {
        double aux = 0;
        for(Double nota : notas) {
            aux += nota;
        }
        return aux/notas.size();
    }

    public Double getMediaNotas() {
        return geraMediaNotas(notas);
    }


}
