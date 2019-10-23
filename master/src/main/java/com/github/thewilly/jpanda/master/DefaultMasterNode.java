package com.github.thewilly.jpanda.master;

import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.master.configuration.MasterNodeConfiguration;
import com.github.thewilly.jpanda.slave.node.ClientNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Default master node.
 */
public final class DefaultMasterNode implements MasterNode {

    private static final Logger logger = LoggerFactory.getLogger(DefaultMasterNode.class);

    private final List<ClientNode> slaves;
    private final ConcurrentLinkedQueue<Job> pendingJobsQueue;
    private final ConcurrentLinkedDeque<Job> executedJobsQueue;
    private final MasterNodeConfiguration configuration;

    private Job executingJob;

    /**
     * Instantiates a new Default master node.
     *
     * @param configuration the configuration
     */
    public DefaultMasterNode(MasterNodeConfiguration configuration) {
        this.configuration = configuration;
        this.slaves = new CopyOnWriteArrayList<ClientNode>();
        this.pendingJobsQueue = new ConcurrentLinkedQueue<Job>();
        this.executedJobsQueue = new ConcurrentLinkedDeque<Job>();

        logger.debug("Default master node created "
                + this.configuration
                + "::" + this.slaves
                + "::" + this.pendingJobsQueue
                + "::" + this.executedJobsQueue
                + "::" + this.executingJob
        );
    }

    /**
     * Add slave node.
     *
     * @param slaveNode the slave node
     */
    public void addSlaveNode(ClientNode slaveNode) {

        logger.debug("Adding node %s to the slaves list", slaveNode);

        this.slaves.add(slaveNode);

        logger.debug("Node %s added to the slaves list", slaveNode);
    }

    /**
     * Gets nex pendingt job.
     *
     * @return the nex pendingt job
     */
    public Job moveToNextJob() {
        if(!this.executingJob.isDone()) {
            logger.error("Trying to move to the next job in the queue while one job %s is executing", this.executingJob);
            throw new IllegalStateException("Previous job has to finish first.");
        }

        Job nextJob = this.pendingJobsQueue.poll();
        this.executingJob = nextJob;
        return nextJob;
    }

    /**
     * Add pending job.
     *
     * @param job the job
     */
    public void addPendingJob(Job job) {
        logger.debug("Adding job %s to the pending jobs list", job);
        checkJobIsNotNull(job);
        this.pendingJobsQueue.add(job);
        logger.debug("Added job %s to the pending jobs list", job);
    }

    /**
     * Gets last executed job.
     *
     * @return the last executed job
     */
    public Job getLastExecutedJob() {
        logger.debug("Accessing to the last executed job", this.executedJobsQueue.getFirst());
        return this.executedJobsQueue.getFirst();
    }

    /**
     * Add executed job.
     *
     * @param job the job
     */
    public void addExecutedJob(Job job) {
        logger.debug("Adding job %s to the executed jobs list", job);
        checkJobIsNotNull(job);
        this.executedJobsQueue.addFirst(job);
        logger.debug("Added job %s to the executed jobs list", job);
    }

    /**
     * Gets configuration.
     *
     * @return the configuration
     */
    public MasterNodeConfiguration getConfiguration() {
        logger.debug("Accessing to the node configuration: %s", this.configuration);
        return this.configuration;
    }

    private void checkJobIsNotNull(Job job) {
        if(job == null) {
            throw new IllegalArgumentException("The job cannot be null");
        }
    }
}
