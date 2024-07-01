package br.edu.imepac.dtos;

import lombok.Data;

@Data
public class ConsultaCreateRequest {
    private Long idFuncionario;
    private Long idMedico;
    private Long idPaciente;
    private String horario;
    private String data;
}
