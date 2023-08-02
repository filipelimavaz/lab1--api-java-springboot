package br.ufpb.dcx.lab1v1.excecoes;

public class DisciplinaJaExistenteException extends AbstracException {

    public DisciplinaJaExistenteException(String titulo, String detalhes) {
        super(titulo, detalhes);
    }
}
