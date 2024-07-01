package br.edu.imepac.services;

import br.edu.imepac.dtos.ConsultaCreateRequest;
import br.edu.imepac.dtos.ConsultaDto;
import br.edu.imepac.models.ConsultaModel;
import br.edu.imepac.repositories.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaDto save(ConsultaCreateRequest consultaRequest) {
        ConsultaModel consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaRequest, consultaModel);
        ConsultaModel savedConsulta = consultaRepository.save(consultaModel);
        return convertToDto(savedConsulta);
    }

    public List<ConsultaDto> findAll() {
        List<ConsultaModel> consultaModels = consultaRepository.findAll();
        return consultaModels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ConsultaDto findById(Long id) {
        ConsultaModel consultaModel = consultaRepository.findById(id).orElse(null);
        if (consultaModel != null) {
            return convertToDto(consultaModel);
        }
        return null;
    }

    public ConsultaDto update(Long id, ConsultaDto consultaDto) {
        ConsultaModel consultaModel = consultaRepository.findById(id).orElse(null);
        if (consultaModel != null) {
            BeanUtils.copyProperties(consultaDto, consultaModel, "id");
            ConsultaModel updatedConsulta = consultaRepository.save(consultaModel);
            return convertToDto(updatedConsulta);
        }
        return null;
    }

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }

    private ConsultaDto convertToDto(ConsultaModel consultaModel) {
        ConsultaDto consultaDto = new ConsultaDto();
        BeanUtils.copyProperties(consultaModel, consultaDto);
        return consultaDto;
    }
}
