package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ProntuarioCreateRequest {
    private String registro;
    private String historico;
    private String receituario;
    private String exames;
}
