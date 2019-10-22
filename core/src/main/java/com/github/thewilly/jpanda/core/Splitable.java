package com.github.thewilly.jpanda.core;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Splitable.
 *
 * @param <T> the type parameter
 */
public interface Splitable<T extends Serializable> extends Serializable {

    /**
     * Split list.
     *
     * @param numberOfChunks the number of chunks
     * @return the list
     */
    List<T[]> split(int numberOfChunks);
}
