package com.github.thewilly.jpanda.core;

import java.util.Collection;

/**
 * The interface com.github.thewilly.jpanda.core.Workload.
 */
public interface Workload {

    /**
     * Gets size.
     *
     * @return the size
     */
    long getSize();

    /**
     * Gets workload.
     *
     * @return the workload
     */
    Collection getWorkload();
}
