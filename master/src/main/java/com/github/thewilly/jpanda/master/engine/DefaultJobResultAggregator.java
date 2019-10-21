package com.github.thewilly.jpanda.master.engine;

import com.github.thewilly.jpanda.core.job.JobResult;
import com.github.thewilly.jpanda.core.task.TaskResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Default job result aggregator.
 *
 * @param <T> the type parameter
 */
public class DefaultJobResultAggregator<T extends Serializable> implements JobResultAggregator<T> {

    private final int numberOfChunks;
    private List<T> result;
    private int aggregatedChunks;

    /**
     * Instantiates a new Default job result aggregator.
     *
     * @param numberOfChunks the number of chunks
     */
    public DefaultJobResultAggregator(int numberOfChunks) {
        this.numberOfChunks = numberOfChunks;
        this.aggregatedChunks = 0;
        this.result = new ArrayList<>();
    }

    @Override
    public void aggregate(TaskResult<T> taskResult) {
        result.addAll(Arrays.asList(taskResult.getResult()));
    }

    @Override
    public JobResult<T> getJoobResult() {
        return new JobResult<T>() {
            @Override
            public T[] getResult() {
                return (T[]) result.toArray();
            }
        };
    }

    @Override
    public boolean isComplete() {
        return aggregatedChunks == numberOfChunks;
    }
}
