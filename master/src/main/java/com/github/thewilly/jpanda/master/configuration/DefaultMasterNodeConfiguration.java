package com.github.thewilly.jpanda.master.configuration;


/**
 * The type Default master node configuration.
 */
public class DefaultMasterNodeConfiguration implements MasterNodeConfiguration {

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
    }

    @Override
    public String getIp() {
        return this.ip;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getMaxNumberOfSlaveNodes() {
        return this.maxNumberOfSlaves;
    }

    @Override
    public long getDefaultJobExecutionTime() {
        return this.maxJobsExecutionTime;
    }

    @Override
    public long getMaxNumberOfQueueJobs() {
        return this.maxNumebrOfQueueJobs;
    }
}
