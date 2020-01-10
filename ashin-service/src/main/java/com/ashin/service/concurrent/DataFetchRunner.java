package com.ashin.service.concurrent;

import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

public class DataFetchRunner<T> implements Runnable {

    @Setter
    private BlockingQueue<DataNode<T>> blockingQueue;

    @Setter
    private DataFetcher fetchFunction;

    @SneakyThrows
    @Override
    public void run() {
        fetchFunction.fetch(blockingQueue);

        blockingQueue.put(DataNode.END_NODE);
    }



}
