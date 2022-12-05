package org.tse.TD1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.TD1.domain.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
