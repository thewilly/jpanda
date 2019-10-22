package com.github.thewilly.jpanda.master;

import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.SplitableWorkload;
import com.github.thewilly.jpanda.master.configuration.DefaultMasterNodeConfiguration;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StartUp {

    private static MasterNode master = new DefaultMasterNode(
            new DefaultMasterNodeConfiguration(
                    "192.168.1.1",
                    2020,
                    "masternode_1",
                    50,
                    1000,
                    10
            ));

    public static void main(String... args) {

        StartUp sp = new StartUp();
        sp.execute();
    }

    public void execute() {
        SplitableWorkload<Integer> intArr = new MyWorkload<>(1,2,3,4,5,6,7,8,9,10);
        AggregableResult<String> results = new MyResult<>();
        Function<Integer, String> f = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return Integer.toString(integer);
            }
        };

        intArr.split(6).forEach((e) -> System.out.println(Arrays.toString(e)));
    }

    public class MyWorkload<T extends Serializable> implements SplitableWorkload<T> {

        T[] data;

        public MyWorkload(T... data) {
            this.data = data;
        }

        @Override
        public T[] getData() {
            return data;
        }

        @Override
        public List<T[]> split(int numberOfChunks) {
            List<T[]> chunks = new ArrayList<T[]>();
            T[] workloadToSplit = data;
            int itemsPerChunk = data.length / numberOfChunks;
            boolean isWorkloadBalanced = data.length % numberOfChunks == 0;

            for(int i = 0; i < numberOfChunks; i++) {
                int startPos = i*itemsPerChunk;
                int endPos = startPos + itemsPerChunk;
                if(isWorkloadBalanced) {
                    chunks.add(Arrays.copyOfRange(workloadToSplit, startPos, endPos));
                } else {
                    if(i == numberOfChunks-1) {
                        chunks.add(Arrays.copyOfRange(workloadToSplit, startPos, workloadToSplit.length-1));
                    }
                }
            }
            return chunks;
        }
    }

    public class MyResult<T extends Serializable> implements AggregableResult<T> {

        T[] data;

        public MyResult(T... data) {
            this.data = data;
        }

        @Override
        public boolean isComputed() {
            return true;
        }

        @Override
        public T[] getData() {
            return data;
        }

        @Override
        public void aggregate(T[] partialResults) {
            // do nothing...
        }
    }
}
