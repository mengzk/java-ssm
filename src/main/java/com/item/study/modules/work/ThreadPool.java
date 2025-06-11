package com.item.study.modules.work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 * public ThreadPoolExecutor(int corePoolSize,
 * int maximumPoolSize,
 * long keepAliveTime,
 * TimeUnit unit,
 * BlockingQueue<Runnable> workQueue,
 * ThreadFactory threadFactory,
 * RejectedExecutionHandler handler)
 * corePoolSize：线程池中的常驻核心线程数。
 * maximumPoolSize：线程池能够容纳同时执行的最大线程数，此值大于等于1。
 * keepAliveTime：多余的空闲线程存活时间，当空间时间达到keepAliveTime值时，多余的线程会被销毁直到只剩下corePoolSize个线程为止。
 * unit：keepAliveTime的单位。
 * workQueue：任务队列，被提交但尚未被执行的任务。
 * threadFactory：表示生成线程池中工作线程的线程工厂，用户创建新线程，一般用默认即可。
 * handler：拒绝策略，表示当线程队列满了并且工作线程大于等于线程池的最大显示数(maxnumPoolSize)时，如何来拒绝请求执行的runnable的策略。
 * 并且Java的线程池是通过 生产者-消费者模式 实现的，线程池的使用方是生产者，而线程池本身就是消费者。
 */
public class ThreadPool {
    //默认阻塞队列大小
    private static final int DEFAULT_WORK_SIZE = 5;

    //模拟实际的线程池使用阻塞队列来实现生产者-消费者模式
    private BlockingQueue<Runnable> workQueue;

    //模拟实际的线程池使用List集合保存线程池内部的工作线程
    private List<WorkThread> workThreads = new ArrayList<WorkThread>();


    private void test() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(6);
    }

    //在ThreadPool的构造方法中传入线程池的大小和阻塞队列
    public ThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        //创建poolSize个工作线程并将其加入到workThreads集合中
        IntStream.range(0, poolSize).forEach((i) -> {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreads.add(workThread);
        });
    }

    //在ThreadPool的构造方法中传入线程池的大小
    public ThreadPool(int poolSize) {
        this(poolSize, new LinkedBlockingQueue<>(DEFAULT_WORK_SIZE));
    }

    //通过线程池执行任务
    public void execute(Runnable task) {
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //内部类WorkThread，模拟线程池中的工作线程
    //主要的作用就是消费workQueue中的任务，并执行
    //由于工作线程需要不断从workQueue中获取任务，使用了while(true)循环不断尝试消费队列中的任务
    class WorkThread extends Thread {
        @Override
        public void run() {
            //不断循环获取队列中的任务
            try {
                while (true) {
                    //当没有任务时，会阻塞
                    Runnable workTask = workQueue.take();
                    workTask.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
