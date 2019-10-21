package com.github.thewilly.jpanda.master.engine;

import com.github.thewilly.jpanda.core.job.JobResult;
import com.github.thewilly.jpanda.core.task.TaskResult;

import java.io.Serializable;

/**
 * The interface Job result aggregator.
 *
 * @param <T> the type parameter
 */
public interface JobResultAggregator<T extends Serializable> {

    /**
     * Aggregate.
     *
     * @param taskResult the task result
     */
    void aggregate(TaskResult<T> taskResult);

    /**
     * Gets joob result.
     *
     * @return the joob result
     */
    JobResult<T> getJoobResult();

    /**
     * Is complete boolean.
     *
     * @return the boolean
     */
    boolean isComplete();
}
