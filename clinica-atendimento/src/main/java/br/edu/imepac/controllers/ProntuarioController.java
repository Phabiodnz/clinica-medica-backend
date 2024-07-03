package br.edu.imepac.controllers;

import br.edu.imepac.dtos.ProntuarioCreateRequest;
import br.edu.imepac.dtos.ProntuarioDto;
import br.edu.imepac.services.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prontuario")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<ProntuarioDto> saveProntuario(@RequestBody ProntuarioCreateRequest prontuarioRequest) {
        ProntuarioDto savedProntuario = prontuarioService.save(prontuarioRequest);
        return new ResponseEntity<>(savedProntuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioDto>> listAllProntuarios() {
        List<ProntuarioDto> prontuarios = prontuarioService.findAll();
        return new ResponseEntity<>(prontuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDto> getProntuarioById(@PathVariable Long id) {
        ProntuarioDto prontuarioDto = prontuarioService.findById(id);
        if (prontuarioDto != null) {
            return new ResponseEntity<>(prontuarioDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioDto> updateProntuario(@PathVariable Long id, @RequestBody ProntuarioDto prontuarioDto) {
        ProntuarioDto updatedProntuario = prontuarioService.update(id, prontuarioDto);
        if (updatedProntuario != null) {
            return new ResponseEntity<>(updatedProntuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProntuario(@PathVariable Long id) {
        prontuarioService.delete(id);
    }
}
