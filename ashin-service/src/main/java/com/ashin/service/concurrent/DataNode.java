package com.ashin.service.concurrent;

public class DataNode<T> {

    public static final DataNode END_NODE = new DataNode(null, Boolean.TRUE);

    private boolean finish = false;

    private T data;

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataNode() {}

    public DataNode(T data) {
        this.data = data;
    }

    public DataNode(T data, boolean finish) {
        this.data = data;
        this.finish = finish;
    }
}
