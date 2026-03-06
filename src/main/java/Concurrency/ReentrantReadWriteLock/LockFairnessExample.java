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
