package com.java.apiservices.controller;

import com.java.apiservices.dto.MasterSubMenuDto;
import com.java.apiservices.dto.Response;
import com.java.apiservices.entity.MasterMenu;
import com.java.apiservices.entity.MasterSubMenu;
import com.java.apiservices.repository.MasterMenuRepository;
import com.java.apiservices.repository.MasterSubMenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rest/master-sub-menu")
@Transactional
public class MasterSubMenuController {
    @Autowired
    MasterMenuRepository masterMenuRepository;
    @Autowired
    MasterSubMenuRepository masterSubMenuRepository;
    @Autowired
    ModelMapper modelMapper;


    @GetMapping("/find-all")
    public Response<Object> findAll(@RequestParam String search, Pageable pageable) {
        Response<Object> response = new Response<>();

        List<MasterSubMenuDto> masterSubMenuDtos = new ArrayList<>();
        for (MasterSubMenu i : masterSubMenuRepository.findAll(search, pageable)) {
            MasterSubMenuDto dto = modelMapper.map(i, MasterSubMenuDto.class);
            dto.setMenuId(i.getMasterMenu().getMenuId());
            masterSubMenuDtos.add(dto);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("items", masterSubMenuDtos);
        res.put("totalItems", masterSubMenuRepository.findAll(search, null).size());
        response.setSuccess(res);
        return response;
    }

    @GetMapping("/findByMenu/{id}")
    public Response<Object> findAll(@PathVariable String id, @RequestParam String search, Pageable pageable) {
        Response<Object> response = new Response<>();

        Optional<MasterMenu> masterMenuOptional = masterMenuRepository.findById(id);
        if (!masterMenuOptional.isPresent()) {
            response.setError("ERR_MENU_ID_NOT_EXIST");
            return response;
        }

        List<MasterSubMenuDto> masterSubMenuDtos = new ArrayList<>();
        for (MasterSubMenu i : masterSubMenuRepository.findByMasterMenu(masterMenuOptional.get(), search, pageable)) {
            MasterSubMenuDto dto = modelMapper.map(i, MasterSubMenuDto.class);
            dto.setMenuId(i.getMasterMenu().getMenuId());
            masterSubMenuDtos.add(dto);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("items", masterSubMenuDtos);
        res.put("masterMenu", masterMenuOptional.get());
        res.put("totalItems", masterSubMenuRepository.findByMasterMenu(masterMenuOptional.get(), search, null).size());
        response.setSuccess(res);
        return response;
    }

    @GetMapping("/find/{id}")
    public Response<Object> findAll(@PathVariable String id) {
        Response<Object> response = new Response<>();

        Optional<MasterSubMenu> optionalEntity = masterSubMenuRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            response.setError("ERR_SUB_MENU_ID_NOT_EXIST");
            return response;
        }
        MasterSubMenuDto dto = modelMapper.map(optionalEntity.get(), MasterSubMenuDto.class);
        dto.setMenuId(optionalEntity.get().getMasterMenu().getMenuId());
        response.setSuccess(dto);
        return response;
    }

    @PostMapping("/save")
    public Response<String> save(@RequestBody MasterSubMenuDto req) {
        Response<String> response = new Response<>();
        try {
            Optional<MasterMenu> optionalEntity = masterMenuRepository.findById(req.getMenuId());
            if (!optionalEntity.isPresent()) {
                response.setError("ERR_MENU_ID_NOT_EXIST");
                return response;
            }
            MasterMenu masterMenu = optionalEntity.get();
            MasterSubMenu masterSubMenu = new MasterSubMenu();
            masterSubMenu.setSubMenuName(req.getSubMenuName());
            masterSubMenu.setSubMenuDescription(req.getSubMenuDescription());
            masterSubMenu.setMasterMenu(masterMenu);
            masterSubMenu.setUrlImage(req.getUrlImage());
            masterSubMenuRepository.save(masterSubMenu);
            response.setSuccess("Master Sub Menu successfully added!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @PutMapping("/update/{id}")
    public Response<String> update(@PathVariable String id, @RequestBody MasterSubMenuDto req) {
        Response<String> response = new Response<>();
        try {
            Optional<MasterSubMenu> optionalEntity = masterSubMenuRepository.findById(id);
            if (!optionalEntity.isPresent()) {
                response.setError("ERR_SUB_MENU_ID_NOT_EXIST");
                return response;
            }

            Optional<MasterMenu> masterMenuOptional = masterMenuRepository.findById(req.getMenuId());
            if (!masterMenuOptional.isPresent()) {
                response.setError("ERR_MENU_ID_NOT_EXIST");
                return response;
            }
            MasterSubMenu masterSubMenu = optionalEntity.get();
            masterSubMenu.setSubMenuName(req.getSubMenuName());
            masterSubMenu.setSubMenuDescription(req.getSubMenuDescription());
            masterSubMenu.setMasterMenu(masterMenuOptional.get());
            masterSubMenu.setUrlImage(req.getUrlImage());
            masterSubMenuRepository.save(masterSubMenu);
            response.setSuccess("Master Sub Menu successfully edited!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response<String> delete(@PathVariable String id) {
        Response<String> response = new Response<>();
        Optional<MasterSubMenu> optionalEntity = masterSubMenuRepository.findById(id);
        if (!optionalEntity.isPresent()) {
            response.setError("ERR_SUB_MENU_ID_NOT_EXIST");
            return response;
        }
        try {
            MasterSubMenu masterSubMenu = optionalEntity.get();
            masterSubMenu.setIsDeleted((short) 1);
            masterSubMenuRepository.save(masterSubMenu);
            response.setSuccess("Master Sub Menu successfully deleted!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

