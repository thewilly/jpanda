package com.github.thewilly.jpanda.slave.node;

import com.github.thewilly.jpanda.core.task.Task;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.task.DefaultTaskExecutor;

import java.net.InetSocketAddress;

public class DefaultClientNode implements ClientNode {

    public final static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    private final String nodeId;
    private final InetSocketAddress clientNodeAdress;
    private final InetSocketAddress masterNodeAdress;

    private ClientNodeState nodeState = ClientNodeState.READY;

    public DefaultClientNode(String nodeId, String ip, int port) {
        this.nodeId = nodeId;
        this.clientNodeAdress = new InetSocketAddress(ip, port);
        this.masterNodeAdress = new InetSocketAddress(ip, port);
    }

    @Override
    public ClientNodeState health() {
        return this.nodeState;
    }

    @Override
    public TaskResult executeTask(Task task) {
        this.nodeState = ClientNodeState.COMPUTING;
        return new DefaultTaskExecutor(task).execute();
    }

    @Override
    public String getIp() {
        return this.clientNodeAdress.getHostName();
    }

    @Override
    public int getPort() {
        return this.clientNodeAdress.getPort();
    }

    @Override
    public String getId() {
        return this.nodeId;
    }
}
