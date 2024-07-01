package br.edu.imepac.services;

import br.edu.imepac.dtos.PacienteCreateRequest;
import br.edu.imepac.dtos.PacienteDto;
import br.edu.imepac.models.PacienteModel;
import br.edu.imepac.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void delete(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<PacienteDto> findAll() {
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(paciente -> {
            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(paciente.getId());
            pacienteDto.setNome(paciente.getNome());
            pacienteDto.setRg(paciente.getRg());
            pacienteDto.setOrgaoEmissor(paciente.getOrgaoEmissor());
            pacienteDto.setCpf(paciente.getCpf());
            pacienteDto.setEndereco(paciente.getEndereco());
            pacienteDto.setNumero(paciente.getNumero());
            pacienteDto.setComplemento(paciente.getComplemento());
            pacienteDto.setBairro(paciente.getBairro());
            pacienteDto.setCidade(paciente.getCidade());
            pacienteDto.setEstado(paciente.getEstado());
            pacienteDto.setTelefone(paciente.getTelefone());
            pacienteDto.setCelular(paciente.getCelular());
            pacienteDto.setDataNascimento(paciente.getDataNascimento());
            pacienteDto.setSexo(paciente.getSexo());
            pacienteDto.setNomeConvenio(paciente.getNomeConvenio());
            return pacienteDto;
        }).collect(Collectors.toList());
    }

    public PacienteDto update(Long id, PacienteDto pacienteDetails) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.findById(id);

        if (optionalPaciente.isPresent()) {
            PacienteModel pacienteModel = optionalPaciente.get();
            pacienteModel.setNome(pacienteDetails.getNome());
            pacienteModel.setRg(pacienteDetails.getRg());
            pacienteModel.setOrgaoEmissor(pacienteDetails.getOrgaoEmissor());
            pacienteModel.setCpf(pacienteDetails.getCpf());
            pacienteModel.setEndereco(pacienteDetails.getEndereco());
            pacienteModel.setNumero(pacienteDetails.getNumero());
            pacienteModel.setComplemento(pacienteDetails.getComplemento());
            pacienteModel.setBairro(pacienteDetails.getBairro());
            pacienteModel.setCidade(pacienteDetails.getCidade());
            pacienteModel.setEstado(pacienteDetails.getEstado());
            pacienteModel.setTelefone(pacienteDetails.getTelefone());
            pacienteModel.setCelular(pacienteDetails.getCelular());
            pacienteModel.setDataNascimento(pacienteDetails.getDataNascimento());
            pacienteModel.setSexo(pacienteDetails.getSexo());
            pacienteModel.setNomeConvenio(pacienteDetails.getNomeConvenio());

            PacienteModel updatedPaciente = pacienteRepository.save(pacienteModel);

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(updatedPaciente.getId());
            pacienteDto.setNome(updatedPaciente.getNome());
            pacienteDto.setRg(updatedPaciente.getRg());
            pacienteDto.setOrgaoEmissor(updatedPaciente.getOrgaoEmissor());
            pacienteDto.setCpf(updatedPaciente.getCpf());
            pacienteDto.setEndereco(updatedPaciente.getEndereco());
            pacienteDto.setNumero(updatedPaciente.getNumero());
            pacienteDto.setComplemento(updatedPaciente.getComplemento());
            pacienteDto.setBairro(updatedPaciente.getBairro());
            pacienteDto.setCidade(updatedPaciente.getCidade());
            pacienteDto.setEstado(updatedPaciente.getEstado());
            pacienteDto.setTelefone(updatedPaciente.getTelefone());
            pacienteDto.setCelular(updatedPaciente.getCelular());
            pacienteDto.setDataNascimento(updatedPaciente.getDataNascimento());
            pacienteDto.setSexo(updatedPaciente.getSexo());
            pacienteDto.setNomeConvenio(updatedPaciente.getNomeConvenio());

            return pacienteDto;
        } else {
            return null;
        }
    }

    public PacienteDto save(PacienteCreateRequest pacienteRequest) {
        PacienteModel pacienteModel = new PacienteModel();
        pacienteModel.setNome(pacienteRequest.getNome());
        pacienteModel.setRg(pacienteRequest.getRg());
        pacienteModel.setOrgaoEmissor(pacienteRequest.getOrgaoEmissor());
        pacienteModel.setCpf(pacienteRequest.getCpf());
        pacienteModel.setEndereco(pacienteRequest.getEndereco());
        pacienteModel.setNumero(pacienteRequest.getNumero());
        pacienteModel.setComplemento(pacienteRequest.getComplemento());
        pacienteModel.setBairro(pacienteRequest.getBairro());
        pacienteModel.setCidade(pacienteRequest.getCidade());
        pacienteModel.setEstado(pacienteRequest.getEstado());
        pacienteModel.setTelefone(pacienteRequest.getTelefone());
        pacienteModel.setCelular(pacienteRequest.getCelular());
        pacienteModel.setDataNascimento(pacienteRequest.getDataNascimento());
        pacienteModel.setSexo(pacienteRequest.getSexo());
        pacienteModel.setNomeConvenio(pacienteRequest.getNomeConvenio());

        PacienteModel savedPaciente = pacienteRepository.save(pacienteModel);

        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(savedPaciente.getId());
        pacienteDto.setNome(savedPaciente.getNome());
        pacienteDto.setRg(savedPaciente.getRg());
        pacienteDto.setOrgaoEmissor(savedPaciente.getOrgaoEmissor());
        pacienteDto.setCpf(savedPaciente.getCpf());
        pacienteDto.setEndereco(savedPaciente.getEndereco());
        pacienteDto.setNumero(savedPaciente.getNumero());
        pacienteDto.setComplemento(savedPaciente.getComplemento());
        pacienteDto.setBairro(savedPaciente.getBairro());
        pacienteDto.setCidade(savedPaciente.getCidade());
        pacienteDto.setEstado(savedPaciente.getEstado());
        pacienteDto.setTelefone(savedPaciente.getTelefone());
        pacienteDto.setCelular(savedPaciente.getCelular());
        pacienteDto.setDataNascimento(savedPaciente.getDataNascimento());
        pacienteDto.setSexo(savedPaciente.getSexo());
        pacienteDto.setNomeConvenio(savedPaciente.getNomeConvenio());

        return pacienteDto;
    }

    public PacienteDto findById(Long id) {
        Optional<PacienteModel> optionalPaciente = pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()) {
            PacienteModel pacienteModel = optionalPaciente.get();
            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(pacienteModel.getId());
            pacienteDto.setNome(pacienteModel.getNome());
            pacienteDto.setRg(pacienteModel.getRg());
            pacienteDto.setOrgaoEmissor(pacienteModel.getOrgaoEmissor());
            pacienteDto.setCpf(pacienteModel.getCpf());
            pacienteDto.setEndereco(pacienteModel.getEndereco());
            pacienteDto.setNumero(pacienteModel.getNumero());
            pacienteDto.setComplemento(pacienteModel.getComplemento());
            pacienteDto.setBairro(pacienteModel.getBairro());
            pacienteDto.setCidade(pacienteModel.getCidade());
            pacienteDto.setEstado(pacienteModel.getEstado());
            pacienteDto.setTelefone(pacienteModel.getTelefone());
            pacienteDto.setCelular(pacienteModel.getCelular());
            pacienteDto.setDataNascimento(pacienteModel.getDataNascimento());
            pacienteDto.setSexo(pacienteModel.getSexo());
            pacienteDto.setNomeConvenio(pacienteModel.getNomeConvenio());

            return pacienteDto;
        } else {
            return null;
        }
    }
}
