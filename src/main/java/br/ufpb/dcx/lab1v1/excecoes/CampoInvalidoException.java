package br.ufpb.dcx.lab1v1.excecoes;

public class CampoInvalidoException extends AbstracException {

    public CampoInvalidoException(String titulo, String detalhes) {
        super(titulo, detalhes);
    }
}
