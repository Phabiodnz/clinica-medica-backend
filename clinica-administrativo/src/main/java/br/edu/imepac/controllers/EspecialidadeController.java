package br.edu.imepac.controllers;

import br.edu.imepac.dtos.EspecialidadeCreateRequest;
import br.edu.imepac.dtos.EspecialidadeDto;
import br.edu.imepac.services.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especialidade")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @PostMapping
    public ResponseEntity<EspecialidadeDto> saveSpecialty(@RequestBody EspecialidadeCreateRequest especialidadeRequest) {
        EspecialidadeDto savedEspecialidade = especialidadeService.save(especialidadeRequest);
        return new ResponseEntity<>(savedEspecialidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EspecialidadeDto>> listAllSpecialties() {
        List<EspecialidadeDto> especialidades = especialidadeService.findAll();
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EspecialidadeDto> getSpecialtyById(@PathVariable Long id) {
        EspecialidadeDto especialidadeDto = especialidadeService.findById(id);
        if (especialidadeDto != null) {
            return new ResponseEntity<>(especialidadeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EspecialidadeDto> updateSpecialty(@PathVariable Long id, @RequestBody EspecialidadeDto especialidadeDetails) {
        EspecialidadeDto updatedEspecialidade = especialidadeService.update(id, especialidadeDetails);
        if (updatedEspecialidade != null) {
            return new ResponseEntity<>(updatedEspecialidade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSpecialty(@PathVariable Long id) {
        especialidadeService.delete(id);
    }
}
