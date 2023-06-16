package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.ParteCuerpo;
import com.gymbe.powergymweb.repository.ParteCuerpoRepository;
import com.gymbe.powergymweb.shared.dto.ParteCuerpoDTO;

@Service
public class ParteCuerpoService {
    
    @Autowired
    private ParteCuerpoRepository parteCuerpoRepository;

    public List<ParteCuerpoDTO> listarPartesCuerpo() {
        List<ParteCuerpo> partesCuerpo = parteCuerpoRepository.findAll();
        return partesCuerpo.stream()
                .map(this::convertToParteCuerpoDTO)
                .collect(Collectors.toList());
    }

    private ParteCuerpoDTO convertToParteCuerpoDTO(ParteCuerpo parteCuerpo) {
        ParteCuerpoDTO parteCuerpoDTO = new ParteCuerpoDTO();
        BeanUtils.copyProperties(parteCuerpo, parteCuerpoDTO);
        return parteCuerpoDTO;
    }
}
