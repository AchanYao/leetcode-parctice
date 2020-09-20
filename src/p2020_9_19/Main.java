package p2020_9_19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 滴滴面试1
 * @author Achan
 * @date 2020/9/19
 */
public class Main {

    public static volatile String s = "A";

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 10L, TimeUnit.MINUTES, new LinkedBlockingQueue<>());
        executorService.execute(new PrintA());
        executorService.execute(new PrintB());
        executorService.execute(new PrintC());
        executorService.shutdown();
    }
}

class PrintA implements Runnable {

    private int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            if ("A".equals(Main.s)) {
                p();
                Main.s = "B";
            }
        }
    }

    public void p() {
        System.out.println(Main.s);
        num--;
    }
}

class PrintC implements Runnable {

    private int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            if ("C".equals(Main.s)) {
                p();
                Main.s = "A";
            }
        }
    }

    public void p() {
        System.out.println(Main.s);
        num--;
    }
}

class PrintB implements Runnable {

    private int num = 10;

    @Override
    public void run() {
        while (num > 0) {
            if ("B".equals(Main.s)) {
                p();
                Main.s = "C";
            }
        }
    }

    public void p() {
        System.out.println(Main.s);
        num--;
    }
}

