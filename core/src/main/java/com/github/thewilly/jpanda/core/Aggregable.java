package com.github.thewilly.jpanda.core;

import java.io.Serializable;

/**
 * The interface Aggregable.
 *
 * @param <T> the type parameter
 */
public interface Aggregable<T extends Serializable> extends Serializable {

    /**
     * Aggregate.
     *
     * @param partialResults the partial results
     */
    void aggregate(T[] partialResults);
}
