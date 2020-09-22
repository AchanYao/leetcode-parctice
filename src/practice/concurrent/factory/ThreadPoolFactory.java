package practice.concurrent.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Achan
 * @date 2020/9/21
 */
public class ThreadPoolFactory implements ThreadFactory {

    public static final int CORE_POOL_SIZE = 3;
    public static final int MAXIMUM_POOL_SIZE = 5;

    public static ThreadPoolExecutor getDefaultThreadPool() {
        return new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(CORE_POOL_SIZE), new ThreadPoolFactory());
    }

    public static ThreadPoolExecutor getDefaultThreadPool(int corePoolSize, int maximumSize) {
        return new ThreadPoolExecutor(corePoolSize, maximumSize, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(corePoolSize), new ThreadPoolFactory());
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
