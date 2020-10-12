package practice.concurrent.locks;

import practice.concurrent.factory.ThreadPoolFactory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重用性
 * @author Achan
 * @date 2020/10/9
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolFactory(), new ThreadPoolExecutor.AbortPolicy());
        executor.execute(new ReenterLock());
        executor.execute(new ReenterLock());
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }
}
