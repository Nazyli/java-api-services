package com.java.apiservices.service;

import com.java.apiservices.dto.MasterMenuDto;
import com.java.apiservices.entity.MasterMenu;
import com.java.apiservices.repository.MasterMenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MasterMenuService {
    @Autowired
    MasterMenuRepository masterMenuRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<MasterMenuDto> findAll(String search, Pageable pageable) {
        List<MasterMenuDto> masterMenuDtos = new ArrayList<>();
        for (MasterMenu i : masterMenuRepository.findAll(search, pageable)) {
            MasterMenuDto dto = modelMapper.map(i, MasterMenuDto.class);
            masterMenuDtos.add(dto);
        }
        return masterMenuDtos;
    }

}
