package com.github.thewilly.jpanda.core.task;

import com.github.thewilly.jpanda.core.Aggregable;
import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.Splitable;
import com.github.thewilly.jpanda.core.SplitableWorkload;

import java.util.function.Function;

/**
 * The interface Task.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public interface Task<T extends Splitable<T>, K extends Aggregable<T>> {

    /**
     * Gets workload.
     *
     * @return the workload
     */
    SplitableWorkload<T> getWorkload();

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
    AggregableResult<K> getResult();

    /**
     * Has finished boolean.
     *
     * @return the boolean
     */
    boolean isDone();
}
