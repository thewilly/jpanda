package com.github.thewilly.jpanda.core.task;

import com.github.thewilly.jpanda.core.AggregableResult;

import java.io.Serializable;

/**
 * The interface Task result.
 *
 * @param <T> the type parameter
 */
public interface TaskResult<T extends Serializable> extends AggregableResult<T> {

    /**
     * Get result t [ ].
     *
     * @return the t [ ]
     */
    T[] getData();
}
