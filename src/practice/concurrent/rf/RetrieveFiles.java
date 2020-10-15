package practice.concurrent.rf;

import java.io.File;
import java.util.concurrent.BlockingDeque;

/**
 * @author Achan
 * @date 2020/10/13
 */
public class RetrieveFiles implements Runnable {

    private final BlockingDeque<File> deque;
    public static boolean isRun = true;
    /**
     * 等待次数，超过该值后线程认为遍历完成
     */
    public static final int WAIT_TIME = 1000;

    private static int fileCount = 0;
    private static int folderCount = 0;

    public RetrieveFiles(BlockingDeque<File> deque) {
        if (deque == null) {
            throw new NullPointerException("Thread: " + Thread.currentThread().getName() + "; Class: " + this.getClass().getName());
        }
        this.deque = deque;
    }

    @Override
    public void run() {
        while (isRun) {
            File file = null;
            int count = 0;
            while (file == null) {
                file = deque.pollFirst();
                if (count++ > WAIT_TIME) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " 等待完成");
                    return;
                }
            }
            if (file.isDirectory()) {
                while (!casFolderCount(folderCount, folderCount + 1)) {}
                File[] files = file.listFiles();
                if (files == null) {
                    System.err.println("Error: " + file.toString());
                    continue;
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        deque.offerLast(f);
                        while (!casFolderCount(folderCount, folderCount + 1)) {}
                    } else {
                        System.out.println(f.toString());
                        while (!casFileCount(fileCount, fileCount + 1)) {}
                    }
                }
            } else {
                System.out.println(file.toString());
                while (!casFileCount(fileCount, fileCount + 1)) {}
            }
        }
    }

    private boolean casFileCount(int except, int value) {
        if (fileCount == except) {
            fileCount = value;
            return true;
        } else {
            return false;
        }
    }

    private boolean casFolderCount(int except, int value) {
        if (folderCount == except) {
            folderCount = value;
            return true;
        } else {
            return false;
        }
    }

    public static int getFileCount() {
        return fileCount;
    }

    public static int getFolderCount() {
        return folderCount;
    }
}
