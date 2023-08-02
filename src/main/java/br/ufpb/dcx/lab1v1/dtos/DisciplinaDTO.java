package br.ufpb.dcx.lab1v1.dtos;

import br.ufpb.dcx.lab1v1.excecoes.DisciplinaInvalidaException;
import br.ufpb.dcx.lab1v1.excecoes.NotaInvalidaException;

import java.util.List;

public class DisciplinaDTO {

    private static long proximoID = 1;
    private long id;
    private String nome;
    private int likes;
    private Double nota;
    private List<Double> notas;

    public DisciplinaDTO(){

    }

    public DisciplinaDTO(String nome) {
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

    public Double getNota() {
        return nota;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public void setNota(Double nota){
        this.nota = nota;
    }
}
