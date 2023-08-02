package br.ufpb.dcx.lab1v1.excecoes;

public class NotaInvalidaException extends AbstracException {

    public NotaInvalidaException(String titulo, String detalhes) {
        super(titulo, detalhes);
    }
}
