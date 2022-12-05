package org.tse.TD1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.TD1.domain.Developer;

//type de primary key//
public interface DeveloperRepo extends JpaRepository<Developer,Long> {





}
