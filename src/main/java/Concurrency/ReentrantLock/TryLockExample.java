package Concurrency.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

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
    final boolean lockAcquired = lock.tryLock();
    if (lockAcquired) {
      try {
        if (i > 0) {
          TimeUnit.MILLISECONDS.sleep(timeout);
          sum += accessResource(id, i - 1, sum, timeout);
        }
        final int number = lock.getHoldCount();
        final float retval = sum + i;
        System.out.println("id: " + id + " number: " + number + " times, retval: " + retval + " i: " + i);
        return retval;
      } catch (final InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.unlock();
      }
    } else {
      System.out.println("id: " + id + " could not acquire the lock, skipping resource access.");
      return sum; // Return the current sum without accessing the resource
    }
  }
}

/*
 * In this example, we use the tryLock method without a timeout to attempt to acquire the lock. If a thread cannot
 * acquire the lock immediately, it will skip accessing the resource and print a message indicating that it could not
 * acquire the lock. This approach allows threads to avoid waiting for the lock, which can help prevent thread
 * starvation and improve overall responsiveness in certain scenarios. However, it may lead to more frequent skipping
 * of resource access if the lock is held by other threads for extended periods, which could impact the performance of
 * the application.
 */