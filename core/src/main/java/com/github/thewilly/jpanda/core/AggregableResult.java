package com.github.thewilly.jpanda.core;

import java.io.Serializable;

/**
 * The interface Aggregable result.
 *
 * @param <T> the type parameter
 */
public interface AggregableResult<T extends Serializable> extends Aggregable<T> {

    /**
     * Is computed boolean.
     *
     * @return the boolean
     */
    boolean isComputed();

    /**
     * Get data t [ ].
     *
     * @return the t [ ]
     */
    T[] getData();
}
