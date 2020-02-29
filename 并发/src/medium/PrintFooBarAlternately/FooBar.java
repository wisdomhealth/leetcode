package medium.PrintFooBarAlternately;

/**
 * TODO:Print FooBar Alternately
 * Suppose we have a class:
 * Suppose you are given the following code:
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 *
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */

import java.util.concurrent.Semaphore;

/**
 * 代码提交结果：
 * Status: Accepted
 * Runtime: 10 ms
 * Faster than: 55.39%
 * Memory Usage: 39.3 MB
 */

class FooBar {
    private int n;
    private Semaphore semaphore_foo,semaphore_bar;
    public FooBar(int n) {
        this.n = n;
        semaphore_foo=new Semaphore(1);
        semaphore_bar=new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore_foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore_bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore_bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore_foo.release();
        }
    }
}