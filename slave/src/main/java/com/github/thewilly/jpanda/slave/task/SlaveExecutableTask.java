package com.github.thewilly.jpanda.slave.task;

import com.github.thewilly.jpanda.core.Aggregable;
import com.github.thewilly.jpanda.core.Splitable;
import com.github.thewilly.jpanda.core.task.Task;

/**
 * The type Slave executable task.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public class SlaveExecutableTask<T extends Splitable<T>, K extends Aggregable<T>> implements Runnable {

    private final Task<T,K> taskToExecute;
    private final SlaveTaskExecutor<T,K> taskExecutor;

    /**
     * Instantiates a new Slave executable task.
     *
     * @param taskToExecute the task to execute
     * @param taskExecutor  the task executor
     */
    public SlaveExecutableTask(Task<T,K> taskToExecute, SlaveTaskExecutor taskExecutor) {
        this.taskToExecute = taskToExecute;
        this.taskExecutor = taskExecutor;
    }

    @Override
    public void run() {
        this.taskToExecute.getResult().aggregate(this.taskExecutor.executeTask(this.taskToExecute));
    }
}
