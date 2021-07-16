package com.java.apiservices.controller;

import com.java.apiservices.dto.MasterMenuDto;
import com.java.apiservices.service.MasterMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/master-menu")
public class MasterMenuController {
    @Autowired
    private MasterMenuService masterMenuService;

    @GetMapping("/find-all")
    public List<MasterMenuDto> findAll(@RequestParam String search,Pageable pageable) {
        return masterMenuService.findAll(search, pageable);
    }
}

