package br.edu.imepac.services;

import br.edu.imepac.dtos.ProntuarioCreateRequest;
import br.edu.imepac.dtos.ProntuarioDto;
import br.edu.imepac.models.ProntuarioModel;
import br.edu.imepac.repositories.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    public ProntuarioDto save(ProntuarioCreateRequest prontuarioRequest) {
        ProntuarioModel prontuarioModel = new ProntuarioModel();
        prontuarioModel.setRegistro(prontuarioRequest.getRegistro());
        prontuarioModel.setHistorico(prontuarioRequest.getHistorico());
        prontuarioModel.setReceituario(prontuarioRequest.getReceituario());
        prontuarioModel.setExames(prontuarioRequest.getExames());

        ProntuarioModel savedProntuario = prontuarioRepository.save(prontuarioModel);

        ProntuarioDto prontuarioDto = new ProntuarioDto();
        prontuarioDto.setId(savedProntuario.getId());
        prontuarioDto.setRegistro(savedProntuario.getRegistro());
        prontuarioDto.setHistorico(savedProntuario.getHistorico());
        prontuarioDto.setReceituario(savedProntuario.getReceituario());
        prontuarioDto.setExames(savedProntuario.getExames());

        return prontuarioDto;
    }

    public List<ProntuarioDto> findAll() {
        List<ProntuarioModel> prontuarioModels = prontuarioRepository.findAll();
        return prontuarioModels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProntuarioDto findById(Long id) {
        Optional<ProntuarioModel> optionalProntuario = prontuarioRepository.findById(id);
        return optionalProntuario.map(this::convertToDto).orElse(null);
    }

    public ProntuarioDto update(Long id, ProntuarioDto prontuarioDto) {
        Optional<ProntuarioModel> optionalProntuario = prontuarioRepository.findById(id);
        if (optionalProntuario.isPresent()) {
            ProntuarioModel prontuarioModel = optionalProntuario.get();
            prontuarioModel.setRegistro(prontuarioDto.getRegistro());
            prontuarioModel.setHistorico(prontuarioDto.getHistorico());
            prontuarioModel.setReceituario(prontuarioDto.getReceituario());
            prontuarioModel.setExames(prontuarioDto.getExames());

            ProntuarioModel updatedProntuario = prontuarioRepository.save(prontuarioModel);
            return convertToDto(updatedProntuario);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        prontuarioRepository.deleteById(id);
    }

    private ProntuarioDto convertToDto(ProntuarioModel prontuarioModel) {
        ProntuarioDto prontuarioDto = new ProntuarioDto();
        prontuarioDto.setId(prontuarioModel.getId());
        prontuarioDto.setRegistro(prontuarioModel.getRegistro());
        prontuarioDto.setHistorico(prontuarioModel.getHistorico());
        prontuarioDto.setReceituario(prontuarioModel.getReceituario());
        prontuarioDto.setExames(prontuarioModel.getExames());
        return prontuarioDto;
    }
}
