package com.github.thewilly.jpanda.master.rest;

import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.job.Job;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.node.ClientNode;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestOperationsController implements RestOperations {

    @Override
    public boolean submitJob(Job job) {
        return false;
    }

    @Override
    public AggregableResult getJobResult(String jobId) {
        return null;
    }

    @Override
    public boolean isJobDone(String jobId) {
        return false;
    }

    @Override
    public boolean removeJob(String jobId) {
        return false;
    }

    @Override
    public boolean aggregateJobResult(TaskResult taskResult) {
        return false;
    }

    @Override
    public boolean register(ClientNode clientNode) {
        return false;
    }

    @Override
    public boolean unRegister(ClientNode clientNode) {
        return false;
    }

    @Override
    public boolean checkConnection() {
        return false;
    }
}
