package com.github.thewilly.jpanda.slave.task;

import com.github.thewilly.jpanda.core.task.TaskResult;

/**
 * The interface Task executor.
 */
public interface TaskExecutor {

    /**
     * Execute task result.
     *
     * @return the task result
     */
    TaskResult execute();

}
