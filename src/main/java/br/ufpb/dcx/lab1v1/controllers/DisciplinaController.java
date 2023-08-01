package br.ufpb.dcx.lab1v1.controllers;

import br.ufpb.dcx.lab1v1.dtos.DisciplinaDTO;
import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import br.ufpb.dcx.lab1v1.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Disciplina> adicionaDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.adicionarDisciplina(disciplinaDTO.getNome()));
    }

    @GetMapping("/v1/api/disciplinas/lista_disciplinas")
    public ResponseEntity<List<Disciplina>> retornaDisciplinas(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.retornaTodasDisciplinas());
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> retornaDisciplina(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.retornaDisciplina(id));
    }

    @PostMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> atualizaDisciplina(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.atualizaDisciplina(id, disciplinaDTO.getNome()));
    }

    @PostMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> adicionaNota(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.adicionaNota(id, disciplinaDTO.getNota()));
    }

    @PostMapping("/v1/api/disciplinas/{id}/like")
    public ResponseEntity<Disciplina> adicionaLike(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.adicionaLike(id));
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> removeDisciplina(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.removeDisciplina(id));
    }

    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<List<Disciplina>> ordenaDisciplinas(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.ordenaDisciplinas());
    }
}
