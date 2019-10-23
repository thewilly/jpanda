package com.github.thewilly.jpanda.core.job;

import com.github.thewilly.jpanda.core.AggregableResult;
import com.github.thewilly.jpanda.core.SplitableWorkload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * The type Abstract job.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 */
public class DefaultJob<T extends SplitableWorkload,K extends AggregableResult> implements Job<T,K> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultJob.class);

    private final SplitableWorkload<T> workload;
    private final Function<T,K> function;
    private final AggregableResult<K> result;
    private final String id;

    /**
     * Instantiates a new Abstract job.
     *
     * @param workload the workload
     * @param function the function
     * @param result   the result
     */
    public DefaultJob(String id, SplitableWorkload<T> workload, Function<T,K> function, AggregableResult<K> result)  {
        this.id = id;
        this.workload = workload;
        this.function = function;
        this.result = result;
        logger.debug("Default job created - " + this.workload + "::" + this.function + "::" + this.result);
    }

    @Override
    public String getId() {
        logger.debug("Accessing the job id");
        return this.id;
    }

    @Override
    public SplitableWorkload<T> getWorkload() {
        logger.debug("Accessing the workload");
        return this.workload;
    }

    @Override
    public Function<T, K> getFunction() {
        logger.debug("Accessing the function");
        return this.function;
    }

    @Override
    public AggregableResult<K> getResult() {
        logger.debug("Accessing the result");
        return this.result;
    }

    @Override
    public boolean isDone() {
        logger.debug("Accessing the is done flag");
        return false;
    }
}
