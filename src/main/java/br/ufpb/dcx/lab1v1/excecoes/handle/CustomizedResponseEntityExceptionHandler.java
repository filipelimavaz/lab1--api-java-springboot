package br.ufpb.dcx.lab1v1.excecoes.handle;

import br.ufpb.dcx.lab1v1.dtos.DetalhesDoProblema;
import br.ufpb.dcx.lab1v1.excecoes.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static String ADICIONA_DISCIPLINA_URI = "https://localhost:8080/v1/api/produtos";

    @ExceptionHandler(CampoInvalidoException.class)
    public ResponseEntity<DetalhesDoProblema> CampoInvalidoBadRequest(CampoInvalidoException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(DisciplinaJaExistenteException.class)
    public ResponseEntity<DetalhesDoProblema> DisciplinaJaExistenteException(DisciplinaJaExistenteException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(DisciplinaInvalidaException.class)
    public ResponseEntity<DetalhesDoProblema> DisciplinaInvalidaException(DisciplinaInvalidaException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(NenhumaDisciplinaCadastradaException.class)
    public ResponseEntity<DetalhesDoProblema> NenhumaDisciplinaCadastradaException(NenhumaDisciplinaCadastradaException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(IdInvalidoException.class)
    public ResponseEntity<DetalhesDoProblema> IdInvalidoException(IdInvalidoException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(AtualizacaoDeNomeInvalidoException.class)
    public ResponseEntity<DetalhesDoProblema> AtualizacaoDeNomeInvalidoException(AtualizacaoDeNomeInvalidoException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }

    @ExceptionHandler(NotaInvalidaException.class)
    public ResponseEntity<DetalhesDoProblema> NotaInvalidaException(NotaInvalidaException exception) {
        DetalhesDoProblema problema = new DetalhesDoProblema();
        problema.setStatus(HttpStatus.BAD_REQUEST.value());
        problema.setTitle(exception.getTitulo());
        problema.setType(ADICIONA_DISCIPLINA_URI);
        problema.setDetail(exception.getDetalhes());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }
}