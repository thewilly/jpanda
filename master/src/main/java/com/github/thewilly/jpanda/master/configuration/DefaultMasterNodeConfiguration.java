package com.github.thewilly.jpanda.master.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Default master node configuration.
 */
public class DefaultMasterNodeConfiguration implements MasterNodeConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DefaultMasterNodeConfiguration.class);

    private final String ip;
    private final int port;
    private final String id;
    private final int maxNumberOfSlaves;
    private final long maxJobsExecutionTime;
    private final long maxNumebrOfQueueJobs;

    /**
     * Instantiates a new Default master node configuration.
     *
     * @param ip                   the ip
     * @param port                 the port
     * @param id                   the id
     * @param maxNumberOfSlaves    the max number of slaves
     * @param maxJobsExecutionTime the max jobs execution time
     * @param maxNumebrOfQueueJobs the max numebr of queue jobs
     */
    public DefaultMasterNodeConfiguration(String ip,
                                           int port,
                                           String id,
                                           int maxNumberOfSlaves,
                                           long maxJobsExecutionTime,
                                           long maxNumebrOfQueueJobs) {
        this.ip = ip;
        this.port = port;
        this.id = id;
        this.maxNumberOfSlaves = maxNumberOfSlaves;
        this.maxJobsExecutionTime = maxJobsExecutionTime;
        this.maxNumebrOfQueueJobs = maxNumebrOfQueueJobs;

        logger.debug("New configuration created %s", this);
    }

    @Override
    public String getIp() {
        logger.debug("Accessing the IP address");
        return this.ip;
    }

    @Override
    public int getPort() {
        logger.debug("Accessing the port");
        return this.port;
    }

    @Override
    public String getId() {
        logger.debug("Accessing the id");
        return this.id;
    }

    @Override
    public int getMaxNumberOfSlaveNodes() {
        logger.debug("Accessing max number of slaves");
        return this.maxNumberOfSlaves;
    }

    @Override
    public long getDefaultJobExecutionTime() {
        logger.debug("Accessing the max time a job is executing");
        return this.maxJobsExecutionTime;
    }

    @Override
    public long getMaxNumberOfQueueJobs() {
        logger.debug("Accessing the max number of queued jobs");
        return this.maxNumebrOfQueueJobs;
    }
}
