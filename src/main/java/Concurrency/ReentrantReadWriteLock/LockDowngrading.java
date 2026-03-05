package Concurrency.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDowngrading {

  private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private static boolean cacheValid = false;
  private static String data = "";

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> System.out.println(getData("A")));
    final Thread thread2 = new Thread(() -> System.out.println(getData("B")));

    thread1.start();
    thread2.start();
  }

  private static String getData(String id) {
    lock.readLock().lock();

    if (!cacheValid) {
      lock.readLock().unlock();

      lock.writeLock().lock();
      try {
        // Double-checked locking
        if (!cacheValid) {
          data = loadData(id);
          cacheValid = true;
        }

        // ↓ LOCK DOWNGRADING
        lock.readLock().lock();

      } finally {
        lock.writeLock().unlock();
      }
    }

    try {
      return data;
    } finally {
      lock.readLock().unlock();
    }
  }

  private static String loadData(String id) {
    return "data " + id;
  }

}

/*
 * Lock downgrading is a technique used in concurrent programming to allow a thread that holds a write lock to downgrade
 * to a read lock without releasing the lock entirely. This can be useful in scenarios where a thread needs to perform
 * some write operations and then continue to read from the shared resource without allowing other threads to acquire
 * the write lock in the meantime.
 *
 * In this example, we demonstrate lock downgrading using a ReentrantReadWriteLock. The getData method first acquires
 * the read lock to check if the cache is valid. If the cache is not valid, it releases the read lock and acquires the
 * write lock to update the cache. After updating the cache, it downgrades to the read lock before releasing the write
 * lock. This allows other threads to read from the cache while it is being updated, improving concurrency and
 * performance in scenarios where there are more read operations than write operations.
 */