package com.github.thewilly.jpanda.slave.task;

import com.github.thewilly.jpanda.core.Aggregable;
import com.github.thewilly.jpanda.core.Splitable;
import com.github.thewilly.jpanda.core.task.Task;

/**
 * The interface Slave task executor.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public interface SlaveTaskExecutor<T extends Splitable<T>, K extends Aggregable<T>> {

    /**
     * Execute task k [ ].
     *
     * @param task the task
     * @return the k [ ]
     */
    K[] executeTask(Task<T,K> task);
}
