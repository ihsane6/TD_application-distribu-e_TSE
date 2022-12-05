package org.tse.TD1.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tse.TD1.dao.DeveloperRepo;
import org.tse.TD1.domain.Developer;

import java.util.List;

@Component
public class DeveloperService implements org.tse.TD1.ServiceInterface.DeveloperService {
    @Autowired
    DeveloperRepo developerRepo;

    @Override
    public List<Developer> findAllDevelopers() {
        List<Developer> developers = developerRepo.findAll();
        return developers;
    }
}
