package com.github.thewilly.jpanda.client;

import com.github.thewilly.jpanda.client.exception.JobNotFoundException;
import com.github.thewilly.jpanda.client.exception.MasterNodeNotAvailableException;
import com.github.thewilly.jpanda.client.exception.ResultsNotAvailableException;
import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.core.job.JobResult;

/**
 * The interface J panda client.
 */
public interface JPandaClient {

    /**
     * Submit job.
     *
     * @param job the job
     * @throws MasterNodeNotAvailableException the master node not available exception
     */
    void submitJob(Job job) throws MasterNodeNotAvailableException;

    /**
     * Execute job.
     *
     * @param jobId the job id
     * @throws MasterNodeNotAvailableException the master node not available exception
     * @throws JobNotFoundException            the job not found exception
     */
    void executeJob(String jobId) throws MasterNodeNotAvailableException, JobNotFoundException;

    /**
     * Has job finished boolean.
     *
     * @param jobId the job id
     * @return the boolean
     * @throws JobNotFoundException the job not found exception
     */
    boolean hasJobFinished(String jobId) throws JobNotFoundException;

    /**
     * Gets job result.
     *
     * @param jobId the job id
     * @return the job result
     * @throws ResultsNotAvailableException the results not available exception
     * @throws JobNotFoundException         the job not found exception
     */
    JobResult getJobResult(String jobId) throws ResultsNotAvailableException, JobNotFoundException;

    /**
     * Sets configuration.
     *
     * @param config the config
     */
    void setConfiguration(Configuration config);
}
