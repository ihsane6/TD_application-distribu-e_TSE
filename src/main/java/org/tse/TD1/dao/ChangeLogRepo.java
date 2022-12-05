package org.tse.TD1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.TD1.domain.ChangeLog;

public interface ChangeLogRepo extends JpaRepository<ChangeLog,Long> {
}
