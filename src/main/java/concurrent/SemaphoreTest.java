package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lizhitao on 16-5-27.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        // 排他锁
        lock.unlock();

        /*Condition condition = lock.newCondition();
        condition.await();
        condition.signal();*/

        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        final Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        print();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        semaphore.release();
                    }
                }
            });
        }
        threadPool.shutdown();
    }


    public static void print() {
        System.out.println(Thread.currentThread().getName());
    }
}
