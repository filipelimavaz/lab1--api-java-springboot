package br.ufpb.dcx.lab1v1.services;

import br.ufpb.dcx.lab1v1.dtos.DisciplinaDTO;
import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import br.ufpb.dcx.lab1v1.excecoes.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DisciplinaService {

    List<Disciplina> disciplinas = new ArrayList<>();
    List<DisciplinaDTO> disciplinasDTO = new ArrayList<>();

    public DisciplinaDTO adicionarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        validaDisciplina(nome);
        verificaDisciplinaCadastrada(nome);
        disciplinas.add(disciplina);
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
        disciplinasDTO.add(disciplinaDTO);
        return disciplinaDTO;
    }

    public List<DisciplinaDTO> retornaTodasDisciplinas() {
        if(disciplinas.size() == 0) {
            throw new NenhumaDisciplinaCadastradaException("Não existe nenhuma disciplina no sistema",
                    "Cadastre alguma disciplina para poder lista-las");
        }
        return disciplinasDTO;
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

    public DisciplinaDTO retornaDisciplinaDTO(Long id) {
        validaID(id);
        for(Disciplina disciplina : disciplinas) {
            if(id == disciplina.getId()) {
                DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
                return disciplinaDTO;
            }
        }
        throw new IdInvalidoException("O id inserido é inválido",
                "Não existe uma disciplina com o id inserido");
    }

    public DisciplinaDTO atualizaDisciplina(Long id, String nome) {
        Disciplina disciplina = retornaDisciplina(id);
        validaDisciplina(nome);
        verificaDisciplinaCadastrada(nome);
        disciplina.setNome(nome);
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
        return disciplinaDTO;
    }

    public DisciplinaDTO adicionaNota(Long id, Double nota) {
        Disciplina disciplina = retornaDisciplina(id);
        verificaNota(nota);
        disciplina.adicionarNota(nota);
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
        disciplinaDTO.setMedia(disciplina.getMediaNotas());
        return disciplinaDTO;
    }

    public DisciplinaDTO adicionaLike(Long id) {
        Disciplina disciplina = retornaDisciplina(id);
        disciplina.adicionaLike();
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
        return disciplinaDTO;
    }

    public DisciplinaDTO removeDisciplina(Long id) {
        Disciplina disciplina = retornaDisciplina(id);
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplina);
        return disciplinaDTO;
    }

    public List<DisciplinaDTO> ordenaDisciplinas() {
        Collections.sort(disciplinasDTO);
        return disciplinasDTO;
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
