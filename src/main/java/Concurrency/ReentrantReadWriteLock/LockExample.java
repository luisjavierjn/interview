package Concurrency.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample {
  private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
  private static final Lock readLock = lock.readLock();
  private static final Lock writeLock = lock.writeLock();

  private static final List<String> resource = new ArrayList<>();

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> readResource("A", 0));
    final Thread thread2 = new Thread(() -> writeResource("B"));
    final Thread thread3 = new Thread(() -> readResource("C", 500));
    final Thread thread4 = new Thread(() -> readResource("D", 100));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }

  private static void readResource(String id, int timeout) {
    readLock.lock();
    try {
      System.out.println("id: " + id + " reading from the resource..." + resource + " number: " + lock.getReadLockCount());
      TimeUnit.MILLISECONDS.sleep(timeout);
    } catch (final InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      readLock.unlock();
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
 * In this example, we use a ReentrantReadWriteLock to manage access to a shared resource. The readResource method
 * acquires the read lock, allowing multiple threads to read from the resource concurrently. The writeResource method
 * acquires the write lock, ensuring that only one thread can write to the resource at a time, and that no threads can
 * read from the resource while it is being written to. This approach allows for better concurrency and performance in
 * scenarios where there are more read operations than write operations, as it allows multiple threads to read from the
 * resource without blocking each other, while still ensuring that write operations are performed safely.
 *
 * Either ReadLock is being used (by n threads) or WriteLock is being used (by 1 thread). Never both at the same time.
 */