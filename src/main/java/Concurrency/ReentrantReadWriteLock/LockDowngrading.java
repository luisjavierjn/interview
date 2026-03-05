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
