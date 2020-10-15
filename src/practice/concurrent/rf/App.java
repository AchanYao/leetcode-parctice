package practice.concurrent.rf;

import java.io.File;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author Achan
 * @date 2020/10/13
 */
public class App {

    public static final String D = "F:\\WorkSpaces\\grades-vue";
    public static final int CPU_NUM = 4;
    public static int count = 0;

    public static void main(String[] args) {
        final BlockingDeque<File> deque = new LinkedBlockingDeque<>();
        File file = new File(D);
        if (file.exists() && file.isDirectory()) {
            deque.offerLast(file);
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(CPU_NUM, CPU_NUM << 1, 10, TimeUnit.MINUTES, new SynchronousQueue<>(), r -> new Thread(r, "Thread-" + count++), new ThreadPoolExecutor.AbortPolicy());

        long start = System.currentTimeMillis();
        System.out.println("Start at " + new Date(start));
        for (int i = 0; i < CPU_NUM << 1; i++) {
            executor.execute(new RetrieveFiles(deque));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }
        RetrieveFiles.isRun = false;
        long end = System.currentTimeMillis();
        System.out.println("End at " + new Date(end));
        System.out.println("it take " + (end - start) / 100  + "s");
        System.out.println("Total file: " + RetrieveFiles.getFileCount() + "; folder: " + RetrieveFiles.getFolderCount());
    }
}
