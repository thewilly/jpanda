package com.github.thewilly.jpanda.core.task;

import com.github.thewilly.jpanda.core.Workload;

import java.io.Serializable;
import java.util.function.Function;

/**
 * The interface Task.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public interface Task<T extends Serializable, K extends Serializable> {

    /**
     * Gets workload.
     *
     * @return the workload
     */
    Workload<T> getWorkload();

    /**
     * Gets function.
     *
     * @return the function
     */
    Function<T,K> getFunction();

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
