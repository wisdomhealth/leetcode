package easy.PrintinOrder;

/**
 * TODO:Print in Order
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 */

import java.util.concurrent.Semaphore;

/**
 * 代码提交结果：
 * Status: Accepted
 * Runtime: 9 ms
 * Memory Usage: 39 MB
 */

class Foo {

    private Semaphore semaphore_second,semaphore_third;

    public Foo() {
        semaphore_second = new Semaphore(0);
        semaphore_third = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore_second.release();

    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore_second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore_third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore_third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}