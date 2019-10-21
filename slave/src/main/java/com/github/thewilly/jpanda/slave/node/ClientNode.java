package com.github.thewilly.jpanda.slave.node;

import com.github.thewilly.jpanda.core.task.Task;
import com.github.thewilly.jpanda.core.task.TaskResult;

/**
 * The interface Client node.
 */
public interface ClientNode {

    /**
     * Health client node state.
     *
     * @return the client node state
     */
    ClientNodeState health();

    /**
     * Execute task task result.
     *
     * @param task the task
     * @return the task result
     */
    TaskResult executeTask(Task task);

    /**
     * Gets ip.
     *
     * @return the ip
     */
    String getIp();

    /**
     * Gets port.
     *
     * @return the port
     */
    int getPort();

    /**
     * Gets id.
     *
     * @return the id
     */
    String getId();
}
