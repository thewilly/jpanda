package com.github.thewilly.jpanda.core;

import java.io.Serializable;

/**
 * The interface com.github.thewilly.jpanda.core.Workload.
 *
 * @param <T> the type parameter
 */
public interface SplitableWorkload<T extends Serializable> extends Splitable<T> {

    /**
     * Gets workload.
     *
     * @return the workload
     */
    T[] getData();
}
