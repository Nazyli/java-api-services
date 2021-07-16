package com.java.apiservices.controller;

import com.java.apiservices.dto.MasterMenuDto;
import com.java.apiservices.dto.Response;
import com.java.apiservices.entity.MasterMenu;
import com.java.apiservices.repository.MasterMenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rest/master-menu")
@Transactional
public class MasterMenuController {
    @Autowired
    MasterMenuRepository masterMenuRepository;
    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/find-all")
    public Response<Object> findAll(@RequestParam String search, Pageable pageable) {
        Response<Object> response = new Response<>();

        List<MasterMenuDto> masterMenuDtos = new ArrayList<>();
        for (MasterMenu i : masterMenuRepository.findAll(search, pageable)) {
            MasterMenuDto dto = modelMapper.map(i, MasterMenuDto.class);
            masterMenuDtos.add(dto);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("items", masterMenuDtos);
        res.put("totalItems", masterMenuRepository.findAll(search, null).size());
        response.setSuccess(res);
        return response;
    }

    @GetMapping("/find/{id}")
    public Response<Object> findAll(@PathVariable String id) {
        Response<Object> response = new Response<>();

        Optional<MasterMenu> optionalEntity = masterMenuRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            response.setError("ERR_MENU_ID_NOT_EXIST");
            return response;
        }
        response.setSuccess(modelMapper.map(optionalEntity.get(), MasterMenuDto.class));
        return response;
    }

    @PostMapping("/save")
    public Response<String> save(@RequestBody MasterMenuDto req) {
        Response<String> response = new Response<>();
        MasterMenu masterMenu = new MasterMenu();
        try {
            masterMenu.setMenuName(req.getMenuName());
            masterMenu.setMenuDescription(req.getMenuDescription());
            masterMenu.setUrlImage(req.getUrlImage());
            masterMenuRepository.save(masterMenu);
            response.setSuccess("Master Menu successfully added!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PutMapping("/update/{id}")
    public Response<String> update(@PathVariable String id, @RequestBody MasterMenuDto req) {
        Response<String> response = new Response<>();
        Optional<MasterMenu> optionalEntity = masterMenuRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            response.setError("ERR_MENU_ID_NOT_EXIST");
            return response;
        }
        try {
            MasterMenu masterMenu = optionalEntity.get();
            masterMenu.setMenuName(req.getMenuName());
            masterMenu.setMenuDescription(req.getMenuDescription());
            masterMenu.setUrlImage(req.getUrlImage());
            masterMenuRepository.save(masterMenu);
            response.setSuccess("Master Menu successfully edited!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response<String> delete(@PathVariable String id) {
        Response<String> response = new Response<>();
        Optional<MasterMenu> optionalEntity = masterMenuRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            response.setError("ERR_MENU_ID_NOT_EXIST");
            return response;
        }
        try {
            MasterMenu masterMenu = optionalEntity.get();
            masterMenu.setIsDeleted((short) 1);
            masterMenuRepository.save(masterMenu);
            response.setSuccess("Master Menu successfully deleted!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

