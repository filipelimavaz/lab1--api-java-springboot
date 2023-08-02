package br.ufpb.dcx.lab1v1.dtos;

import br.ufpb.dcx.lab1v1.entidades.Disciplina;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO implements Comparable<DisciplinaDTO>{

    private long id;
    private String nome;
    private int likes;
    private Double media;

    public DisciplinaDTO(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.likes = disciplina.getLikes();
        this.media = disciplina.getMediaNotas();
    }

    public void setNota(Double nota){
        this.media = nota;
    }

    @Override
    public int compareTo(DisciplinaDTO disciplinaDTO) {
        if(this.media > disciplinaDTO.getMedia()) {
            return -1;
        } else if(this.media.equals(disciplinaDTO.getMedia())) {
            return 0;
        } else {
            return 1;
        }
    }
}
