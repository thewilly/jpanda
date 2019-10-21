package com.github.thewilly.jpanda.core.task;

import java.io.Serializable;

/**
 * The interface Task result.
 *
 * @param <T> the type parameter
 */
public interface TaskResult<T extends Serializable> {

    /**
     * Get result t [ ].
     *
     * @return the t [ ]
     */
    T[] getResult();
}
