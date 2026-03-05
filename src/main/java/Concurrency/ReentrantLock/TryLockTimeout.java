package Concurrency.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTimeout {

  private static final ReentrantLock lock = new ReentrantLock(true);

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> plainAccessResource("A", 3, 0, 500));
    final Thread thread2 = new Thread(() -> plainAccessResource("B", 5, 0, 300));
    final Thread thread3 = new Thread(() -> plainAccessResource("C", 2, 0, 100));
    final Thread thread4 = new Thread(() -> plainAccessResource("D", 4, 0, 400));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }

  private static void plainAccessResource(String id, int i, float sum, int timeout) {
    try {
      sum = accessResource(id, i, sum, timeout);
      System.out.println("id: " + id + " final sum: " + sum + " i: " + i);
    } catch (final InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private static float accessResource(String id, int i, float sum, int timeout) throws InterruptedException {
    final boolean lockAcquired = lock.tryLock(5, TimeUnit.SECONDS);
    if (lockAcquired) {
      try {
        if (i > 0) {
          Thread.sleep(timeout);
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
    } else {
      System.out.println("id: " + id + " could not acquire the lock, skipping resource access.");
      return sum; // Return the current sum without accessing the resource
    }
  }
}

/*
 * In this example, we use the tryLock method with a timeout to attempt to acquire the lock. If a thread cannot acquire
 * the lock within the specified timeout, it will skip accessing the resource and print a message indicating that it
 * could not acquire the lock. This approach allows threads to avoid waiting indefinitely for the lock, which can help
 * prevent thread starvation and improve overall responsiveness in certain scenarios.
 *
 * Even if the ReentrantLock is fair the tryLock() doesn't honor the fairness
 * the workaround for this is saying tryLock with a timeout of zero seconds:
 * ReentrantLock lock = new ReentrantLock(true);
 * boolean lockAcquired = lock.tryLock(0, TimeUnit.SECONDS);
 */