package org.tse.TD1.ServiceInterface;

import org.tse.TD1.domain.Task;

import java.util.Collection;

public interface TaskService {
    public Collection<Task> findAllTasks();

    public Task findTask(Long id);

    public Task moveRightTask(Task task);

    public Task moveLeftTask(Task task);
}
