package br.edu.imepac.services;

import br.edu.imepac.dtos.ConvenioCreateRequest;
import br.edu.imepac.dtos.ConvenioDto;
import br.edu.imepac.models.ConvenioModel;
import br.edu.imepac.repositories.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;

    public void delete(Long id) {
        convenioRepository.deleteById(id);
    }

    public List<ConvenioDto> findAll() {
        List<ConvenioModel> convenios = convenioRepository.findAll();
        return convenios.stream().map(convenio -> {
            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(convenio.getId());
            convenioDto.setEmpresaConvenio(convenio.getEmpresaConvenio());
            convenioDto.setCnpj(convenio.getCnpj());
            convenioDto.setTelefone(convenio.getTelefone());
            return convenioDto;
        }).collect(Collectors.toList());
    }

    public ConvenioDto update(Long id, ConvenioDto convenioDetails) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);

        if (optionalConvenio.isPresent()) {
            ConvenioModel convenioModel = optionalConvenio.get();
            convenioModel.setEmpresaConvenio(convenioDetails.getEmpresaConvenio());
            convenioModel.setCnpj(convenioDetails.getCnpj());
            convenioModel.setTelefone(convenioDetails.getTelefone());

            ConvenioModel updatedConvenio = convenioRepository.save(convenioModel);

            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(updatedConvenio.getId());
            convenioDto.setEmpresaConvenio(updatedConvenio.getEmpresaConvenio());
            convenioDto.setCnpj(updatedConvenio.getCnpj());
            convenioDto.setTelefone(updatedConvenio.getTelefone());
            return convenioDto;
        } else {
            return null;
        }
    }

    public ConvenioDto save(ConvenioCreateRequest convenioRequest) {
        ConvenioModel convenioModel = new ConvenioModel();
        convenioModel.setEmpresaConvenio(convenioRequest.getEmpresaConvenio());
        convenioModel.setCnpj(convenioRequest.getCnpj());
        convenioModel.setTelefone(convenioRequest.getTelefone());

        ConvenioModel savedConvenio = convenioRepository.save(convenioModel);

        ConvenioDto convenioDto = new ConvenioDto();
        convenioDto.setId(savedConvenio.getId());
        convenioDto.setEmpresaConvenio(savedConvenio.getEmpresaConvenio());
        convenioDto.setCnpj(savedConvenio.getCnpj());
        convenioDto.setTelefone(savedConvenio.getTelefone());

        return convenioDto;
    }

    public ConvenioDto findById(Long id) {
        Optional<ConvenioModel> optionalConvenio = convenioRepository.findById(id);
        if (optionalConvenio.isPresent()) {
            ConvenioModel convenioModel = optionalConvenio.get();
            ConvenioDto convenioDto = new ConvenioDto();
            convenioDto.setId(convenioModel.getId());
            convenioDto.setEmpresaConvenio(convenioModel.getEmpresaConvenio());
            convenioDto.setCnpj(convenioModel.getCnpj());
            convenioDto.setTelefone(convenioModel.getTelefone());
            return convenioDto;
        } else {
            return null;
        }
    }
}
