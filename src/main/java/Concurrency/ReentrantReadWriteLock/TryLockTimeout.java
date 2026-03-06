package Concurrency.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TryLockTimeout {
  private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private static final Lock readLock = lock.readLock();
  private static final Lock writeLock = lock.writeLock();

  private static final List<String> resource = new ArrayList<>();

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> writeResource("A"));
    final Thread thread2 = new Thread(() -> readResource("B"));
    final Thread thread3 = new Thread(() -> readResource("C"));
    final Thread thread4 = new Thread(() -> readResource("D"));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }

  private static void readResource(String id) {
    try {
      final boolean lockAcquired = readLock.tryLock(5, TimeUnit.SECONDS);
      if (lockAcquired) {
        try {
          System.out.println("id: " + id + " reading from the resource..." + resource + " number: " + lock.getReadLockCount());
        } finally {
          readLock.unlock();
        }
      } else {
        System.out.println("id: " + id + " could not acquire the read lock, skipping resource access.");
      }
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void writeResource(String id) {
    writeLock.lock();
    try {
      final String data = "Data from " + id;
      resource.add(data);
      System.out.println("id: " + id + " writing to the resource..." + data + " number: " + lock.getWriteHoldCount());
    } finally {
      writeLock.unlock();
    }
  }
}

/*
 * In this example, we use the tryLock method with a timeout to attempt to acquire the read lock. If a thread cannot
 * acquire the read lock within the specified timeout, it will skip accessing the resource and print a message
 * indicating that it could not acquire the lock. This approach allows threads to avoid waiting indefinitely for the
 * lock, which can help prevent thread starvation and improve overall responsiveness in certain scenarios.
 *
 * The writeResource method still uses a regular lock acquisition, as it is essential for ensuring that write operations
 * are performed safely. However, the readResource method can gracefully handle situations where the read lock is not
 * available, allowing for better concurrency and performance in scenarios where there are more read operations than
 * write operations.
 *
 * Either ReadLock is being used (by n threads) or WriteLock is being used (by 1 thread). Never both at the same time.
 */
