package com.github.thewilly.jpanda.master.rest;

import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.core.job.JobResult;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.node.ClientNode;

import java.io.Serializable;

/**
 * The interface Rest operations.
 */
public interface RestOperations<T extends Serializable,K extends Serializable> {

    /**
     * Submit job boolean.
     *
     * @param job the job
     * @return the boolean
     */
    boolean submitJob(Job<T,K> job);

    /**
     * Gets job result.
     *
     * @param jobId the job id
     * @return the job result
     */
    JobResult<K> getJobResult(String jobId);

    /**
     * Is job done boolean.
     *
     * @param jobId the job id
     * @return the boolean
     */
    boolean isJobDone(String jobId);

    /**
     * Remove job boolean.
     *
     * @param jobId the job id
     * @return the boolean
     */
    boolean removeJob(String jobId);

    /**
     * Aggregate job result boolean.
     *
     * @param taskResult the task result
     * @return the boolean
     */
    boolean aggregateJobResult(TaskResult<K> taskResult);

    /**
     * Register boolean.
     *
     * @param clientNode the client node
     * @return the boolean
     */
    boolean register(ClientNode clientNode);

    /**
     * Un register boolean.
     *
     * @param clientNode the client node
     * @return the boolean
     */
    boolean unRegister(ClientNode clientNode);

    /**
     * Check connection boolean.
     *
     * @return the boolean
     */
    boolean checkConnection();
}
