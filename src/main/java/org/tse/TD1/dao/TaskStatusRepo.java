package org.tse.TD1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.TD1.domain.TaskStatus;

public interface TaskStatusRepo extends JpaRepository<TaskStatus,Long> {
}
