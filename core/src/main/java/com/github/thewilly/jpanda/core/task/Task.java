package com.github.thewilly.jpanda.core.task;

import com.github.thewilly.jpanda.core.Workload;

import java.util.function.Function;

/**
 * The interface Task.
 */
public interface Task {

    /**
     * Gets workload.
     *
     * @return the workload
     */
    Workload getWorkload();

    /**
     * Gets function.
     *
     * @return the function
     */
    Function getFunction();

    /**
     * Gets result.
     *
     * @return the result
     */
    TaskResult getResult();

    /**
     * Has finished boolean.
     *
     * @return the boolean
     */
    boolean isDone();
}
