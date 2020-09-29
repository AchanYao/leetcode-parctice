package leetcode.package_1195;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Achan
 * @date 2020/9/19
 */
public class Solution1195 {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread fizz = new Thread(() -> fizzBuzz.fizz());
        Thread buzz = new Thread(() -> fizzBuzz.buzz());
        Thread fizzBuzzT = new Thread(() -> fizzBuzz.fizzbuzz());
        Thread number = new Thread(() -> fizzBuzz.number());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(fizz);
        executorService.execute(buzz);
        executorService.execute(fizzBuzzT);
        executorService.execute(number);
        executorService.shutdown();
    }
}

class FizzBuzz {
    private int n;
    private int x = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() {
        // printFizz.run() outputs "fizz".
        while (x < n) {
            while (x % 3 != 0 || x % 15 == 0) {
                if (x >= n) {
                    return;
                }
                Thread.yield();
            }
            System.out.println("fizz");
            x++;
        }
    }

    public void buzz() {
        // printBuzz.run() outputs "buzz".
        while (x < n) {
            while (x % 5 != 0 || x % 15 == 0) {
                if (x >= n) {
                    return;
                }
                Thread.yield();
            }
            System.out.println("buzz");
            x++;
        }
    }

    public void fizzbuzz() {
        // printFizzBuzz.run() outputs "fizzbuzz".
        while (x < n) {
            while (x % 3 != 0 || x % 5 != 0) {
                if (x >= n) {
                    return;
                }
                Thread.yield();
            }
            System.out.println("fizzbuzz");
            x++;
        }
    }

    public void number() {
        while (x < n) {
            while (x % 3 == 0 || x % 5 == 0) {
                if (x >= n) {
                    return;
                }
                Thread.yield();
            }
            System.out.println(x);
            x++;
        }
    }
}