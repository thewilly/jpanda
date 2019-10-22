package com.github.thewilly.jpanda.slave.task;

import com.github.thewilly.jpanda.core.task.Task;
import com.github.thewilly.jpanda.core.task.TaskResult;
import com.github.thewilly.jpanda.slave.node.DefaultClientNode;

import java.util.function.Function;

/**
 * The type Default task executor.
 */
public class DefaultTaskExecutor implements TaskExecutor {

    private final Task executingTask;

    /**
     * Instantiates a new Default task executor.
     *
     * @param taskToExecute the task to execute
     */
    public DefaultTaskExecutor(Task taskToExecute) {
        this.executingTask = taskToExecute;
    }

    @Override
    public TaskResult execute() {
        Thread[] threads = new Thread[DefaultClientNode.NUMBER_OF_CORES];

        if(executingTask.getWorkload().getData().length <= DefaultClientNode.NUMBER_OF_CORES) {
            for(int i = 0; i<executingTask.getWorkload().getData().length; i++) {
                int finalI = i;
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        executingTask.getFunction().apply(executingTask.getWorkload().getData()[finalI]);
                    }
                });
            }
        } else {

            int itemsPerThread = executingTask.getWorkload().getData().length / DefaultClientNode.NUMBER_OF_CORES;
            boolean isWorkloadBalanced = executingTask.getWorkload().getData().length % DefaultClientNode.NUMBER_OF_CORES == 0;

            for(int i = 0; i < DefaultClientNode.NUMBER_OF_CORES; i++) {
                int finalI = i;
                threads[i] = new Thread(() -> {
                    int startPos = finalI*itemsPerThread;
                    int endPos = startPos + itemsPerThread;
                    for(int i1 = startPos; i1 < endPos; i1++ ) {
                        executingTask.getFunction().apply(executingTask.getWorkload().getData()[i1]);
                    }
                });

                if(!isWorkloadBalanced && i==DefaultClientNode.NUMBER_OF_CORES-1) {
                    threads[i] = new Thread(() -> {
                        int startPos = finalI*itemsPerThread;
                        int endPos = executingTask.getWorkload().getData().length;
                        for(int i12 = startPos; i12 < endPos; i12++ ) {
                            executingTask.getFunction().apply(executingTask.getWorkload().getData()[i12]);
                        }
                    });
                }

                threads[i].start();
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
