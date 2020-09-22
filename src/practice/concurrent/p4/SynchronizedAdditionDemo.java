package practice.concurrent.p4;

import practice.concurrent.factory.ThreadPoolFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Achan
 * @date 2020/9/21
 */
public class SynchronizedAdditionDemo {
    public static int num = 1000;

    public static void main(String[] args) {
        ThreadPoolExecutor analysisThreadPool = ThreadPoolFactory.getDefaultThreadPool();
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolFactory.getDefaultThreadPool(num, num);
        ThreadPoolExecutor optimisticLockExecutor = ThreadPoolFactory.getDefaultThreadPool(num, num);
        ThreadPoolExecutor synchronizedAdditionPool = ThreadPoolFactory.getDefaultThreadPool(num, num);
        ThreadPoolExecutor volatileAdditionPool = ThreadPoolFactory.getDefaultThreadPool(num, num);
        analysisThreadPool.execute(new TimeUtil(threadPoolExecutor, Addition.class.getSimpleName()));
        analysisThreadPool.execute(new TimeUtil(synchronizedAdditionPool, SynchronizedAddition.class.getSimpleName()));
        analysisThreadPool.execute(new TimeUtil(optimisticLockExecutor, OptimisticLockAddition.class.getSimpleName()));
        analysisThreadPool.execute(new TimeUtil(volatileAdditionPool, AdditionByVolatile.class.getSimpleName()));
        for (int i = 0; i < num; i++) {
            threadPoolExecutor.execute(new Addition());
            synchronizedAdditionPool.execute(new SynchronizedAddition());
            optimisticLockExecutor.execute(new OptimisticLockAddition());
            volatileAdditionPool.execute(new AdditionByVolatile());
        }
        threadPoolExecutor.shutdown();
        synchronizedAdditionPool.shutdown();
        optimisticLockExecutor.shutdown();
        volatileAdditionPool.shutdown();
        analysisThreadPool.shutdown();
        System.out.println(Addition.class.getSimpleName() + " : " + Addition.sum);
        System.out.println(SynchronizedAddition.class.getSimpleName() + " : " + SynchronizedAddition.sum);
        System.out.println(OptimisticLockAddition.class.getSimpleName() + " : " + SynchronizedAddition.sum);
        System.out.println(AdditionByVolatile.class.getSimpleName() + " : " + AdditionByVolatile.sum.get());
    }

    private static class TimeUtil implements Runnable {
        private ThreadPoolExecutor poolExecutor;
        private String name;

        public TimeUtil(ThreadPoolExecutor poolExecutor, String name) {
            this.poolExecutor = poolExecutor;
            this.name = name;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println(name + " ThreadPool start at " + start);
            while (!poolExecutor.isTerminating()) {
                Thread.yield();
            }
            long end = System.currentTimeMillis();
            System.out.println(name + " ThreadPool terminated at " + end + ", " + (end - start) + " in total");
        }
    }
}

class Addition implements Runnable {
    public static Integer sum = 0;

    @Override
    public void run() {
        sum++;
    }
}

class AdditionByVolatile implements Runnable {
    public static AtomicInteger sum = new AtomicInteger(0);

    @Override
    public void run() {
        sum.incrementAndGet();
    }
}

class OptimisticLockAddition implements Runnable {
    public static Integer sum = 0;

    @Override
    public void run() {
        while (!compareAndSet(sum, sum + 1)) {
        }
    }

    private boolean compareAndSet(int except, int value) {
        if (sum == except) {
            sum = value;
            return true;
        } else {
            System.out.println("except: " + except + ", " + value);
            return false;
        }
    }
}

class SynchronizedAddition implements Runnable {
    public static Integer sum = 0;

    public synchronized static void add() {
        sum++;
    }

    @Override
    public void run() {
        add();
    }
}
