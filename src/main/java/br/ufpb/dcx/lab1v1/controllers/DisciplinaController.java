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

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<DisciplinaDTO> adicionaDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.adicionarDisciplina(disciplinaDTO.getNome()));
    }

    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<DisciplinaDTO>> retornaDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.retornaTodasDisciplinas());
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<DisciplinaDTO> retornaDisciplina(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.retornaDisciplinaDTO(id));
    }

    @PostMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<DisciplinaDTO> atualizaDisciplina(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.atualizaDisciplina(id, disciplinaDTO.getNome()));
    }

    @PostMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<DisciplinaDTO> adicionaNota(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.adicionaNota(id, disciplinaDTO.getMedia()));
    }

    @PostMapping("/v1/api/disciplinas/{id}/like")
    public ResponseEntity<DisciplinaDTO> adicionaLike(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.adicionaLike(id));
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<DisciplinaDTO> removeDisciplina(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.removeDisciplina(id));
    }

    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<List<DisciplinaDTO>> ordenaDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.ordenaDisciplinas());
    }
}
