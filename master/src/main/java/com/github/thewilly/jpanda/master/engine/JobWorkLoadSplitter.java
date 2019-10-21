package com.github.thewilly.jpanda.master.engine;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Job work load splitter.
 *
 * @param <T> the type parameter
 */
public interface JobWorkLoadSplitter<T extends Serializable> {

    /**
     * Split list.
     *
     * @return the list
     */
    List<T[]> split();
}
