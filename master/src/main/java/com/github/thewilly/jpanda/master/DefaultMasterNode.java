package com.github.thewilly.jpanda.master;

import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.master.configuration.MasterNodeConfiguration;
import com.github.thewilly.jpanda.slave.node.ClientNode;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Default master node.
 */
public final class DefaultMasterNode implements MasterNode {

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
    }

    /**
     * Add slave node.
     *
     * @param slaveNode the slave node
     */
    public void addSlaveNode(ClientNode slaveNode) {
        this.slaves.add(slaveNode);
    }

    /**
     * Gets nex pendingt job.
     *
     * @return the nex pendingt job
     */
    public Job moveToNextJob() {
        if(!this.executingJob.isDone()) throw new IllegalStateException("Previous job has to finish first.");

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
        checkJobIsNotNull(job);
        this.pendingJobsQueue.add(job);
    }

    /**
     * Gets last executed job.
     *
     * @return the last executed job
     */
    public Job getLastExecutedJob() {
        return this.executedJobsQueue.getFirst();
    }

    /**
     * Add executed job.
     *
     * @param job the job
     */
    public void addExecutedJob(Job job) {
        checkJobIsNotNull(job);
        this.executedJobsQueue.addFirst(job);
    }

    /**
     * Gets configuration.
     *
     * @return the configuration
     */
    public MasterNodeConfiguration getConfiguration() {
        return this.configuration;
    }

    private void checkJobIsNotNull(Job job) {
        if(job == null) throw new IllegalArgumentException("The job cannot be null");
    }
}
