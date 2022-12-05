package org.tse.TD1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tse.TD1.ServiceImplementation.DeveloperService;
import org.tse.TD1.domain.Developer;

import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    DeveloperService developerService;
    @GetMapping("/developers")
    public List<Developer> getdevelopper(){
        return developerService.findAllDevelopers();
    }

}
