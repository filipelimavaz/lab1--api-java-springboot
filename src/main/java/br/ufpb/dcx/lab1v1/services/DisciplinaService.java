package br.ufpb.dcx.lab1v1.services;

import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import br.ufpb.dcx.lab1v1.excecoes.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DisciplinaService {

    List<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina adicionarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        validaDisciplina(nome);
        verificaDisciplinaCadastrada(nome);
        disciplinas.add(disciplina);
        return disciplina;
    }

    public List<Disciplina> retornaTodasDisciplinas() {
        if(disciplinas.size() == 0) {
            throw new NenhumaDisciplinaCadastradaException("Não existe nenhuma disciplina no sistema",
                    "Cadastre alguma disciplina para poder lista-las");
        }
        return disciplinas;
    }

    public Disciplina retornaDisciplina(Long id) {
        validaID(id);
        for(Disciplina disciplina : disciplinas) {
            if(id == disciplina.getId()) {
                return disciplina;
            }
        }
        throw new IdInvalidoException("O id inserido é inválido",
                "Não existe uma disciplina com o id inserido");
    }

    public Disciplina atualizaDisciplina(Long id, String nome) {
        Disciplina disciplina = retornaDisciplina(id);
        validaDisciplina(nome);
        verificaDisciplinaCadastrada(nome);

        disciplina.setNome(nome);
        return disciplina;
    }

    public Disciplina adicionaNota(Long id, Double nota) {
        Disciplina disciplina = retornaDisciplina(id);
        verificaNota(nota);
        disciplina.adicionarNota(nota);
        return disciplina;
    }

    public Disciplina adicionaLike(Long id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.adicionaLike();
        return disciplina;
    }

    public Disciplina removeDisciplina(Long id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplinas.remove(disciplina);
        return disciplina;
    }

    public List<Disciplina> ordenaDisciplinas() {
        Collections.sort(disciplinas, Collections.reverseOrder());
        return disciplinas;
    }

    public boolean validaDisciplina(String nome) {
        if (nome == null || nome.isBlank() || nome.isEmpty())
            throw new DisciplinaInvalidaException("Nome invalido.", "O nome da disciplina é um campo de texto obrigatorio.");
        return true;
    }

    public boolean validaID(Long id) {
        if (id == null || id < 1) {
            throw new IdInvalidoException("ID invalido.", "O id da disciplina é um valor positivo.");
        }
        return true;
    }

    public boolean verificaDisciplinaCadastrada(String nome) {
        for (Disciplina index : disciplinas) {
            if (index.getNome().equalsIgnoreCase(nome)) {
                throw new DisciplinaJaExistenteException("Disciplina já existe no sistema",
                        "Esta disciplina já existe no sistema e só pode ser atualizada.");
            }
        }
        return true;
    }

    public boolean verificaNota(Double nota) {
        if(nota == null || nota < 0 ) {
            throw new NotaInvalidaException("Nota inválida",
                    "Esta nota tem que ser um valor maior ou igual a zero e não pode ser nula");
        }
        return true;
    }


}
