package com.ashin.service.concurrent;

import java.util.concurrent.BlockingQueue;

@FunctionalInterface
public interface DataFetcher<T> {

    void fetch(BlockingQueue<DataNode<T>> blockingQueue) throws Exception;

}
