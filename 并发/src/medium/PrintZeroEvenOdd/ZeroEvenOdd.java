package medium.PrintZeroEvenOdd;

/**
 * TODO:Print Zero Even Odd
 *
 * Suppose you are given the following code:
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // constructor
 *   public void zero(printNumber) { ... }  // only output 0's
 *   public void even(printNumber) { ... }  // only output even numbers
 *   public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 *
 * Input: n = 5
 * Output: "0102030405"
 *
 */

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 代码提交结果：
 * Status: Accepted
 * Runtime: 6 ms
 * Faster than: 71.55%
 * Memory Usage: 39.2 MB
 */

class ZeroEvenOdd {
    private int n;
    private Semaphore semaphore_zero, semaphore_even, semaphore_odd;
    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphore_zero = new Semaphore(1);
        semaphore_even = new Semaphore(0);
        semaphore_odd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int i=0;
        while(i<n) {
            semaphore_zero.acquire();
            printNumber.accept(0);
            if (i%2!=0) {
                semaphore_even.release();
            } else {
                semaphore_odd.release();
            }
            semaphore_zero.acquire();
            i++;
            semaphore_zero.release();
        }
    }
    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i=i+2) {
            semaphore_even.acquire();
            printNumber.accept(i);
            semaphore_zero.release();
        }
    }
    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i=i+2) {
            semaphore_odd.acquire();
            printNumber.accept(i);
            semaphore_zero.release();
        }
    }
}