package com.github.thewilly.jpanda.core.job;

import com.github.thewilly.jpanda.core.Workload;

import java.io.Serializable;
import java.util.function.Function;

/**
 * The interface com.github.thewilly.jpanda.core.job.Job.
 */
public interface Job extends Serializable {

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
    JobResult getResult();

    /**
     * Has finished boolean.
     *
     * @return the boolean
     */
    boolean hasFinished();
}
