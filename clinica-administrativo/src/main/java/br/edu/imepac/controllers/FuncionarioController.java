package br.edu.imepac.controllers;

import br.edu.imepac.models.FuncionarioModel;
import br.edu.imepac.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioModel> saveFuncionario(@RequestBody FuncionarioModel funcionarioCreateRequest) {
        FuncionarioModel savedFuncionario = funcionarioService.save(funcionarioCreateRequest);
        return new ResponseEntity<>(savedFuncionario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listAllFuncionarios() {
        List<FuncionarioModel> funcionarios = funcionarioService.findAll();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FuncionarioModel> getFuncionarioById(@PathVariable Long id) {
        FuncionarioModel funcionarioDto = funcionarioService.findById(id);
        if (funcionarioDto != null) {
            return new ResponseEntity<>(funcionarioDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FuncionarioModel> updateFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioDetails) {
        FuncionarioModel updatedFuncionario = funcionarioService.update(id, funcionarioDetails);
        if (updatedFuncionario != null) {
            return new ResponseEntity<>(updatedFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFuncionario(@PathVariable Long id) {
        funcionarioService.delete(id);
    }
}
