package br.ufpb.dcx.lab1v1.entidades;

import br.ufpb.dcx.lab1v1.excecoes.DisciplinaInvalidaException;
import br.ufpb.dcx.lab1v1.excecoes.DisciplinaJaExistenteException;
import br.ufpb.dcx.lab1v1.excecoes.IdInvalidoException;
import br.ufpb.dcx.lab1v1.excecoes.NotaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Disciplina implements Comparable<Disciplina>{

    private static long proximoID = 1;
    private long id;
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

    /*public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }*/

    public void adicionarNota(Double nota) {
        notas.add(nota);
    }

    public void adicionaLike() {
        this.likes += 1;
    }

    public Double geraMediaNotas(List<Double> notas) {
        double aux = 0;
        for(Double nota : notas) {
            aux += nota;
        }
        return aux/notas.size();
    }

    public Double getMediaNotas() {
        return geraMediaNotas(notas);
    }

    @Override
    public int compareTo(Disciplina disc) {
        if(this.getMediaNotas() > disc.getMediaNotas()) {
            return -1;
        } else if(this.getMediaNotas() == disc.getMediaNotas()) {
            return 0;
        } else {
            return 1;
        }
    }
}
