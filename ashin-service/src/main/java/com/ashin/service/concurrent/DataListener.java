package com.ashin.service.concurrent;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

@Slf4j
public abstract class DataListener<T> implements Runnable {

    @Setter
    private BlockingQueue<DataNode<T>> blockingQueue;

    public  static Logger logger= LoggerFactory.getLogger(DataListener.class);

    @SneakyThrows
    @Override
    public void run() {
        doBefore();
        while (true) {
            DataNode<T> queueNode = blockingQueue.take();

            int num=blockingQueue.remainingCapacity();
            if(queueNode.isFinish()) {
                break;
            }
            execute(queueNode.getData());
        }
        
        doAfterAllExported();
    }

    public void doBefore() throws Exception {}

    public abstract void execute(T data) throws Exception;

    public void doAfterAllExported() throws Exception {}
}
