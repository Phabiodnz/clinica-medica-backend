package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ProntuarioDto {
    private Long id;
    private String registro;
    private String historico;
    private String receituario;
    private String exames;
}

