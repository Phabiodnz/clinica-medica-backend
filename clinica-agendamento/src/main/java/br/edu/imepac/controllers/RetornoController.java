package br.edu.imepac.controllers;

import br.edu.imepac.dtos.RetornoCreateRequest;
import br.edu.imepac.dtos.RetornoDto;
import br.edu.imepac.services.RetornoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("retorno")
public class RetornoController {

    @Autowired
    private RetornoService retornoService;

    @PostMapping
    public ResponseEntity<RetornoDto> saveRetorno(@RequestBody RetornoCreateRequest retornoRequest) {
        RetornoDto savedRetorno = retornoService.save(retornoRequest);
        return new ResponseEntity<>(savedRetorno, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RetornoDto>> listAllRetornos() {
        List<RetornoDto> retornos = retornoService.findAll();
        return new ResponseEntity<>(retornos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RetornoDto> getRetornoById(@PathVariable Long id) {
        RetornoDto retornoDto = retornoService.findById(id);
        if (retornoDto != null) {
            return new ResponseEntity<>(retornoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetornoDto> updateRetorno(@PathVariable Long id, @RequestBody RetornoDto retornoDto) {
        RetornoDto updatedRetorno = retornoService.update(id, retornoDto);
        if (updatedRetorno != null) {
            return new ResponseEntity<>(updatedRetorno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRetorno(@PathVariable Long id) {
        retornoService.delete(id);
    }
}

