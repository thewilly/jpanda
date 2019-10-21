package com.github.thewilly.jpanda.core.job;

import com.github.thewilly.jpanda.core.Workload;

import java.io.Serializable;
import java.util.function.Function;

/**
 * The interface com.github.thewilly.jpanda.core.job.Job.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public interface Job<T extends Serializable, K extends Serializable> extends Serializable {

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
    Function<T, K> getFunction();

    /**
     * Gets result.
     *
     * @return the result
     */
    JobResult<K> getResult();

    /**
     * Has finished boolean.
     *
     * @return the boolean
     */
    boolean isDone();
}
