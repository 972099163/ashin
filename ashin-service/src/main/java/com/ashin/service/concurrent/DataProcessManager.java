package com.ashin.service.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessManager {


    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(0,40,
            60L,TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new DataExportThreadFactory());

    public static <T> void combine(DataFetcher<T> fetchFunction, DataListener<T> dataExporter) {
        BlockingQueue<DataNode<T>> blockingQueue = new ArrayBlockingQueue<>(30);

        DataFetchRunner fetchProcessor = new DataFetchRunner();
        fetchProcessor.setBlockingQueue(blockingQueue);
        fetchProcessor.setFetchFunction(fetchFunction);

        dataExporter.setBlockingQueue(blockingQueue);

        EXECUTOR_SERVICE.execute(dataExporter);
        EXECUTOR_SERVICE.execute(fetchProcessor);
    }

    static class DataExportThreadFactory implements ThreadFactory {

        private AtomicInteger index = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "data-exporter-thread-" + index.getAndIncrement());
        }
    }
}
