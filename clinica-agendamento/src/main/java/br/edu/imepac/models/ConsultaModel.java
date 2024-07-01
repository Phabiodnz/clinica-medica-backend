package br.edu.imepac.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "consulta")
@Data
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idFuncionario;
    private Long idMedico;
    private Long idPaciente;
    private String horario;
    private String data;
}
