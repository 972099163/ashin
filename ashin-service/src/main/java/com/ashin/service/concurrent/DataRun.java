package com.ashin.service.concurrent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DataRun {
    public void DataRun() {
        DataFetcher<String> fetcher = blockingQueue -> {
            blockingQueue.put(new DataNode<>("222"));
        };
        DataListener<String> exporter = new DataListener<String>() {
            @Override
            public void execute(String data) throws Exception {
                System.out.println(data);
            }
        };
        DataProcessManager.combine(fetcher, exporter);
    }

    public static void main(String[] args) {
        DataRun dataRun=new DataRun();
        dataRun.DataRun();
    }
}
