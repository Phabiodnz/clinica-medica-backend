package br.edu.imepac.services;

import br.edu.imepac.dtos.RetornoCreateRequest;
import br.edu.imepac.dtos.RetornoDto;
import br.edu.imepac.models.RetornoModel;
import br.edu.imepac.repositories.RetornoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetornoService {

    @Autowired
    private RetornoRepository retornoRepository;

    public RetornoDto save(RetornoCreateRequest retornoRequest) {
        RetornoModel retornoModel = new RetornoModel();
        BeanUtils.copyProperties(retornoRequest, retornoModel);
        RetornoModel savedRetorno = retornoRepository.save(retornoModel);
        return convertToDto(savedRetorno);
    }

    public List<RetornoDto> findAll() {
        List<RetornoModel> retornoModels = retornoRepository.findAll();
        return retornoModels.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public RetornoDto findById(Long id) {
        RetornoModel retornoModel = retornoRepository.findById(id).orElse(null);
        if (retornoModel != null) {
            return convertToDto(retornoModel);
        }
        return null;
    }

    public RetornoDto update(Long id, RetornoDto retornoDto) {
        RetornoModel retornoModel = retornoRepository.findById(id).orElse(null);
        if (retornoModel != null) {
            BeanUtils.copyProperties(retornoDto, retornoModel, "id");
            RetornoModel updatedRetorno = retornoRepository.save(retornoModel);
            return convertToDto(updatedRetorno);
        }
        return null;
    }

    public void delete(Long id) {
        retornoRepository.deleteById(id);
    }

    private RetornoDto convertToDto(RetornoModel retornoModel) {
        RetornoDto retornoDto = new RetornoDto();
        BeanUtils.copyProperties(retornoModel, retornoDto);
        return retornoDto;
    }
}
