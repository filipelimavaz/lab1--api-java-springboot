package br.ufpb.dcx.lab1v1.excecoes;

public class AtualizacaoDeNomeInvalidoException extends AbstracException {
    public AtualizacaoDeNomeInvalidoException(String titulo, String detalhes) {
        super(titulo, detalhes);
    }
}
