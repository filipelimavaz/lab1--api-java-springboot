package br.ufpb.dcx.lab1v1.services;

import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class DisciplinaService {

    List<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina adicionarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public Disciplina retornaTodasDisciplinas() {
        if(disciplinas.size() != 0) {
            for(int i = 0; i < disciplinas.size(); i++) {
                return disciplinas.get(i);
            }
        }
        return null;
    }

    public Disciplina retornaDisciplina(int id) {
        for(Disciplina disciplina : disciplinas) {
            if(id == disciplina.getId()) {
                return disciplina;
            }
        }
        return null;
    }

    public void deletaDisciplina(int id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplinas.remove(disciplina);
    }

    public Disciplina atualizaDisciplina(int id, String nome) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.setNome(nome);
        return disciplina;
    }

    public Disciplina adicionaNota(int id, double nota) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.setNotas(nota);
    }
}
