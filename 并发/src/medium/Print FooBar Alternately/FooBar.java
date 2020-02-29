package medium.add2numbers;

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

/**
 * 代码提交结果：
 * Status: Accepted
 * Runtime: 10 ms
 * Faster than: 55.39%
 * Memory Usage: 39.3 MB
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