package Concurrency.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockFairnessExample {
  // FAIR = prioridad por orden de llegada (evita que nuevos readers se cuelen delante del writer en cola)
  private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
  private static final Lock readLock = lock.readLock();
  private static final Lock writeLock = lock.writeLock();

  private static final List<String> resource = new ArrayList<>();

  public static void main(String... reentrantLock) {
    final Thread thread1 = new Thread(() -> readResource("A"));
    final Thread thread2 = new Thread(() -> writeResource("B"));
    final Thread thread3 = new Thread(() -> readResource("C"));
    final Thread thread4 = new Thread(() -> readResource("D"));

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }

  private static void readResource(String id) {
    readLock.lock();
    try {
      System.out.println("id: " + id + " reading from the resource..." + resource + " number: " + lock.getReadLockCount());
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
 * In this example, we create a ReentrantReadWriteLock with the fairness policy set to true. This means that threads
 * will acquire the lock in the order they requested it, which can help prevent thread starvation and ensure that all
 * threads get a chance to access the shared resource. The readResource method acquires the read lock, allowing multiple
 * threads to read from the resource concurrently, while the writeResource method acquires the write lock, ensuring that
 * only one thread can write to the resource at a time. By using a fair lock, we can ensure that threads are treated
 * fairly and that no thread is indefinitely blocked from accessing the resource.
 *
 * Note: Using a fair lock can lead to reduced throughput in some scenarios due to increased context switching and
 * overhead associated with managing the queue of waiting threads. It's important to consider the specific requirements
 * of your application when deciding whether to use a fair or non-fair lock.
 *
 * Either ReadLock is being used (by n threads) or WriteLock is being used (by 1 thread). Never both at the same time.
 */