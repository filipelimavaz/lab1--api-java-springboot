package br.ufpb.dcx.lab1v1.excecoes;

public class DisciplinaInvalidaException extends AbstracException {

    public DisciplinaInvalidaException(String titulo, String detalhes) {
        super(titulo, detalhes);
    }
}
