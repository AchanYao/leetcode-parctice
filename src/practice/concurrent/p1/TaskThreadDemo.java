package practice.concurrent.p1;

import practice.concurrent.factory.ThreadPoolFactory;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Achan
 * @date 2020/9/21
 */
public class TaskThreadDemo {


    public static void main(String[] args) throws IOException {
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        ThreadPoolExecutor executor = ThreadPoolFactory.getDefaultThreadPool();
        executor.execute(printA);
        executor.execute(printB);
        executor.execute(print100);
        executor.shutdown();
    }
}

class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    public PrintChar(char c, int t) {
        this.charToPrint = c;
        this.times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int n) {
        this.lastNum = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}
