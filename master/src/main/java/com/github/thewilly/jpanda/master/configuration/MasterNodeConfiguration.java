package com.github.thewilly.jpanda.master.configuration;

/**
 * The interface Master node configuration.
 */
public interface MasterNodeConfiguration {

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

    /**
     * Gets max number of slave nodes.
     *
     * @return the max number of slave nodes
     */
    int getMaxNumberOfSlaveNodes();

    /**
     * Gets default job execution time.
     *
     * @return the default job execution time
     */
    long getDefaultJobExecutionTime();

    /**
     * Gets max number of queue jobs.
     *
     * @return the max number of queue jobs
     */
    long getMaxNumberOfQueueJobs();
}
