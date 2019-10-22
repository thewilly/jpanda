package com.github.thewilly.jpanda.core.job;

import com.github.thewilly.jpanda.core.Aggregable;
import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.Splitable;
import com.github.thewilly.jpanda.core.SplitableWorkload;

import java.util.function.Function;

/**
 * The type Abstract job.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public class DefaultJob<T extends SplitableWorkload,K extends AggregableResult> implements Job<T,K> {

    private final SplitableWorkload<T> workload;
    private final Function<T,K> function;
    private final AggregableResult<K> result;

    /**
     * Instantiates a new Abstract job.
     *
     * @param workload the workload
     * @param function the function
     * @param result   the result
     */
    public DefaultJob(SplitableWorkload<T> workload, Function<T,K> function, AggregableResult<K> result)  {
        this.workload = workload;
        this.function = function;
        this.result = result;
    }

    @Override
    public SplitableWorkload<T> getWorkload() {
        return this.workload;
    }

    @Override
    public Function<T, K> getFunction() {
        return this.function;
    }

    @Override
    public AggregableResult<K> getResult() {
        return this.result;
    }

    @Override
    public boolean isDone() {
        return false;
    }
}
