package com.github.thewilly.jpanda.master.engine;

import com.github.thewilly.jpanda.core.Workload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Default job workload splitter.
 *
 * @param <T> the type parameter
 */
public class DefaultJobWorkloadSplitter<T extends Serializable> implements JobWorkLoadSplitter {

    private final Workload<T> workload;
    private final int numberObChunks;

    /**
     * Instantiates a new Default job workload splitter.
     *
     * @param workload       the workload
     * @param numberOfChunks the number of chunks
     */
    public DefaultJobWorkloadSplitter(Workload workload, int numberOfChunks) {
        this.workload = workload;
        this.numberObChunks = numberOfChunks;
    }

    @Override
    public List<T[]> split() {
        List<T[]> chunks = new ArrayList<T[]>();
        T[] workloadToSplit = workload.getWorkload();
        int itemsPerChunk = workload.getSize() / this.numberObChunks;
        boolean isWorkloadBalanced = workload.getSize() % this.numberObChunks == 0;

        for(int i = 0; i < this.numberObChunks; i++) {
            int startPos = i*itemsPerChunk;
            int endPos = startPos + itemsPerChunk;
            if(isWorkloadBalanced) {
                chunks.set(i, Arrays.copyOfRange(workloadToSplit, startPos, endPos));
            } else {
                if(i == this.numberObChunks-1) {
                    chunks.set(i, Arrays.copyOfRange(workloadToSplit, startPos, chunks.size()-1));
                }
            }
        }
        return chunks;
    }
}
