package Concurrency.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

  private static final ReentrantLock lock = new ReentrantLock(true);

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> accessResource("A", 3, 0, 500));
    final Thread thread2 = new Thread(() -> accessResource("B", 5, 0, 300));
    final Thread thread3 = new Thread(() -> accessResource("C", 2, 0, 100));
    final Thread thread4 = new Thread(() -> accessResource("D", 4, 0, 400));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }

  private static float accessResource(String id, int i, float sum, int timeout) {
    lock.lock();
    try {
      if (i > 0) {
        TimeUnit.MILLISECONDS.sleep(timeout);
        sum += accessResource(id, i - 1, sum, timeout);
      }
      final int number = lock.getHoldCount();
      final float retval = sum + i;
      System.out.println("id: " + id + " number: " + number + " times, retval: " + retval + " i: " + i);
      return retval;
    } catch (final InterruptedException e) { // Handle the exception given by Thread.sleep()
      throw new RuntimeException(e);
    } finally {
      lock.unlock();
    }
  }
}

/*
 * El metodo lock de la clase ReentrantLock , bloquea el código que está en encerrado por el lock y el unlock.
 *
 * One thread at a time can acquire the lock, and other threads will be blocked until the lock is released. The lock is
 * reentrant, meaning that the same thread can acquire the lock multiple times without causing a deadlock. The lock must
 * be released the same number of times it was acquired to fully release it. In this example, we create multiple threads
 * that access a shared resource using the accessResource method, which is protected by a ReentrantLock. Each thread
 * will acquire the lock, perform some operations, and then release the lock, allowing other threads to access the
 * resource in a controlled manner.
 *
 * ReentrantLock is a mutual exclusion lock that allows the same thread to acquire the lock multiple times without
 * causing a deadlock. It provides more flexibility than synchronized blocks, such as the ability to interrupt threads
 * waiting for the lock and to specify a fairness policy. In this example, we create multiple threads that access a
 * shared resource using the accessResource method, which is protected by a ReentrantLock.
 * Each thread will acquire the lock, perform some operations, and then release the lock, allowing other threads to
 * access the resource in a controlled manner.
 *
 *             | Advantages of ReentrantLock  | Disadvantages of ReentrantLock |
 * ------------|------------------------------|--------------------------------|
 * Fair lock   | Equal chance for all threads | Slower                         |
 * Unfair lock | Faster (more throughput)     | Possible thread starvation     |
 */