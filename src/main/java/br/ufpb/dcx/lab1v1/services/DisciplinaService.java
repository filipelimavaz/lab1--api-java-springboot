package br.ufpb.dcx.lab1v1.services;

import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DisciplinaService {

    List<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina adicionarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public List<Disciplina> retornaTodasDisciplinas() {
        return disciplinas;
    }

    public Disciplina retornaDisciplina(int id) {
        for(Disciplina disciplina : disciplinas) {
            if(id == disciplina.getId()) {
                return disciplina;
            }
        }
        return null;
    }

    public Disciplina atualizaDisciplina(int id, String nome) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.setNome(nome);
        return disciplina;
    }

    public Disciplina adicionaNota(int id, double nota) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.adicionarNota(nota);
        return disciplina;
    }

    public Disciplina adicionaLike(int id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.adicionaLike();
        return disciplina;
    }

    public Disciplina removeDisciplina(int id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplinas.remove(disciplina);
        return disciplina;
    }

    public List<Disciplina> ordenaDisciplinas() {
        Collections.sort(disciplinas, Collections.reverseOrder());
        return disciplinas;
    }

}
