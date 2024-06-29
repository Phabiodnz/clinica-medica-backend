package br.edu.imepac.services;

import br.edu.imepac.models.FuncionarioModel;
import br.edu.imepac.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<FuncionarioModel> findAll() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel update(Long id, FuncionarioModel funcionarioDetails) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);

        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funcionarioModel = optionalFuncionario.get();
            funcionarioModel.setNome(funcionarioDetails.getNome());
            funcionarioModel.setRg(funcionarioDetails.getRg());
            funcionarioModel.setOrgaoEmissor(funcionarioDetails.getOrgaoEmissor());
            funcionarioModel.setCpf(funcionarioDetails.getCpf());
            funcionarioModel.setEndereco(funcionarioDetails.getEndereco());
            funcionarioModel.setNumero(funcionarioDetails.getNumero());
            funcionarioModel.setComplemento(funcionarioDetails.getComplemento());
            funcionarioModel.setBairro(funcionarioDetails.getBairro());
            funcionarioModel.setCidade(funcionarioDetails.getCidade());
            funcionarioModel.setEstado(funcionarioDetails.getEstado());
            funcionarioModel.setTelefone(funcionarioDetails.getTelefone());
            funcionarioModel.setCtps(funcionarioDetails.getCtps());
            funcionarioModel.setPis(funcionarioDetails.getPis());
            funcionarioModel.setDataNascimento(funcionarioDetails.getDataNascimento());

            return funcionarioRepository.save(funcionarioModel);
        } else {
            return null;
        }
    }

    public FuncionarioModel save(FuncionarioModel funcionarioRequest) {
        return funcionarioRepository.save(funcionarioRequest);
    }

    public FuncionarioModel findById(Long id) {
        Optional<FuncionarioModel> optionalFuncionario = funcionarioRepository.findById(id);
        return optionalFuncionario.orElse(null);
    }
}
