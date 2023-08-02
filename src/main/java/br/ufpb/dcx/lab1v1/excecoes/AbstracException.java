package br.ufpb.dcx.lab1v1.excecoes;

public abstract class AbstracException extends RuntimeException{

    private String titulo;
    private String detalhes;

    public AbstracException(String titulo, String detalhes) {
        this.detalhes = detalhes;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}
