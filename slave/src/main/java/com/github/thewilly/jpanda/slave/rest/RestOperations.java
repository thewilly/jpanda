package com.github.thewilly.jpanda.slave.rest;

import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.SplitableWorkload;
import com.github.thewilly.jpanda.core.task.Task;
import com.github.thewilly.jpanda.slave.node.ClientNodeState;

/**
 * The interface Rest operations.
 */
public interface RestOperations {

    /**
     * Execute task.
     *
     * @param <T>  the type parameter
     * @param <K>  the type parameter
     * @param task the task
     */
    <T extends SplitableWorkload<T>, K extends AggregableResult<T>>
    void executeTask(Task<T,K> task);

    /**
     * Gets executing task. If no task is being executed returns null.
     *
     * @param <T> the type parameter
     * @param <K> the type parameter
     * @return the executing task
     */
    <T extends SplitableWorkload<T>, K extends AggregableResult<T>>
    Task<T,K> getExecutingTask();

    /**
     * Health client node state.
     *
     * @return the client node state
     */
    ClientNodeState health();

    /**
     * Cancel executing task and returns if was possible.
     * If no task is executing or cannot halt the execution
     * of the task will return false.
     *
     * @return the boolean
     */
    boolean cancelExecutingTask();
}
