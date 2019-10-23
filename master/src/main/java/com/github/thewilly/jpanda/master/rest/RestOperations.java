package com.github.thewilly.jpanda.master.rest;

import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.SplitableWorkload;
import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.node.ClientNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The interface Rest operations.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
@RestController
@RequestMapping("default")
public interface RestOperations<T extends SplitableWorkload<T>,K extends AggregableResult<T>> {

    /**
     * Submit job boolean.
     *
     * @param job the job
     * @return the boolean
     */
    @RequestMapping(value = "/job", method = RequestMethod.POST)
    boolean submitJob(Job<T,K> job);

    /**
     * Gets job result.
     *
     * @param jobId the job id
     * @return the job result
     */
    AggregableResult<K> getJobResult(String jobId);

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
