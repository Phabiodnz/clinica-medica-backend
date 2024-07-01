package br.edu.imepac.controllers;

import br.edu.imepac.dtos.ConsultaCreateRequest;
import br.edu.imepac.dtos.ConsultaDto;
import br.edu.imepac.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDto> saveConsulta(@RequestBody ConsultaCreateRequest consultaRequest) {
        ConsultaDto savedConsulta = consultaService.save(consultaRequest);
        return new ResponseEntity<>(savedConsulta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDto>> listAllConsultas() {
        List<ConsultaDto> consultas = consultaService.findAll();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDto> getConsultaById(@PathVariable Long id) {
        ConsultaDto consultaDto = consultaService.findById(id);
        if (consultaDto != null) {
            return new ResponseEntity<>(consultaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDto> updateConsulta(@PathVariable Long id, @RequestBody ConsultaDto consultaDto) {
        ConsultaDto updatedConsulta = consultaService.update(id, consultaDto);
        if (updatedConsulta != null) {
            return new ResponseEntity<>(updatedConsulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteConsulta(@PathVariable Long id) {
        consultaService.delete(id);
    }
}
