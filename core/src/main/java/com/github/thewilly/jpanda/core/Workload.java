package com.github.thewilly.jpanda.core;

import java.io.Serializable;
import java.util.Collection;

/**
 * The interface com.github.thewilly.jpanda.core.Workload.
 *
 * @param <T> the type parameter
 */
public interface Workload<T extends Serializable> extends Serializable {

    /**
     * Gets size.
     *
     * @return the size
     */
    int getSize();

    /**
     * Gets workload.
     *
     * @return the workload
     */
    T[] getWorkload();
}
