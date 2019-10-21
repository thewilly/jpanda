package com.github.thewilly.jpanda.slave.task;

import com.github.thewilly.jpanda.core.task.Task;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.node.DefaultClientNode;

import java.util.function.Function;

public class DefaultTaskExecutor implements TaskExecutor {

    private final Task executingTask;
    private final Object[] workload;
    private final Function function;

    public DefaultTaskExecutor(Task taskToExecute) {
        this.executingTask = taskToExecute;
        this.workload = taskToExecute.getWorkload().getWorkload().toArray();
        this.function = this.executingTask.getFunction();
    }

    @Override
    public TaskResult execute() {
        Thread[] threads = new Thread[DefaultClientNode.NUMBER_OF_CORES];

        if(executingTask.getWorkload().getSize() <= DefaultClientNode.NUMBER_OF_CORES) {
            for(int i = 0; i<workload.length; i++) {
                int finalI = i;
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        function.apply(workload[finalI]);
                    }
                });
            }
        } else {

            int itemsPerThread = workload.length / DefaultClientNode.NUMBER_OF_CORES;
            boolean isWorkloadBalanced = workload.length % DefaultClientNode.NUMBER_OF_CORES == 0;

            for(int i = 0; i < DefaultClientNode.NUMBER_OF_CORES; i++) {
                int finalI = i;
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int startPos = finalI*itemsPerThread;
                        int endPos = startPos + itemsPerThread;
                        for(int i = startPos; i < endPos; i++ ) {
                            function.apply(workload[i]);
                        }
                    }
                });

                if(!isWorkloadBalanced && i==DefaultClientNode.NUMBER_OF_CORES-1) {
                    threads[i] = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int startPos = finalI*itemsPerThread;
                            int endPos = workload.length;
                            for(int i = startPos; i < endPos; i++ ) {
                                function.apply(workload[i]);
                            }
                        }
                    });
                }
            }

            for(Thread t : threads) {
                t.start();
            }

            for(Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }
}
