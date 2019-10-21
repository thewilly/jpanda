package com.github.thewilly.jpanda.core.job;

import java.io.Serializable;
import java.util.Collection;

/**
 * The interface com.github.thewilly.jpanda.core.job.Job result.
 *
 * @param <T> the type parameter
 */
public interface JobResult<T extends Serializable> {

    /**
     * Gets result.
     *
     * @return the result
     */
    T[] getResult();
}
