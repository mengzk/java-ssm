package com.item.study.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class ThreadPool {
    private Executor diskPool;
    private Executor socketPool;
    private static volatile ThreadPool pool;

    private ThreadPool() {
        initPool();
    }

    public static ThreadPool create() {
        if (pool == null) {
            synchronized (ThreadPool.class) {
                if(pool == null) {
                    pool = new ThreadPool();
                }
            }
        }
        return pool;
    }

    public void initPool() {
        int threadNum = Runtime.getRuntime().availableProcessors();
        System.out.println("ThreadPool ------> size：" + threadNum);
        socketPool = Executors.newSingleThreadExecutor();
        diskPool = Executors.newFixedThreadPool(threadNum);
    }

    public void execute(Runnable task) {
        diskPool.execute(task);
    }

    public void executeSocket(Runnable task) {
        socketPool.execute(task);
    }

    public void shutdown() {
        if (diskPool != null) {
            diskPool = null;
        }
        if (socketPool != null) {
            socketPool = null;
        }
    }
}
