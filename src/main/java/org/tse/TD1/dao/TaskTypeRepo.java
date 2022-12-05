package org.tse.TD1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.TD1.domain.TaskType;

public interface TaskTypeRepo extends JpaRepository<TaskType,Long> {
}
