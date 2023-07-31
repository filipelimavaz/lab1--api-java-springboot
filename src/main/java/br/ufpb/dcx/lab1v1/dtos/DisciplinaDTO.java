package br.ufpb.dcx.lab1v1.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class DisciplinaDTO {

    @Getter
    @NoArgsConstructor
    @Setter
    public class DisciplinasDTOs {

        private int id;
        private String nome;
        private int likes;
        private List<Double> notas;
    }
}
