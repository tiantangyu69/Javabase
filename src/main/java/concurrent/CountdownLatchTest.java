package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lizhitao on 16-5-27.
 */
public class CountdownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            public void run() {
                System.out.println("1111");
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("2222");
                countDownLatch.countDown();
            }
        }).start();

        /*new Thread(new Runnable() {
            public void run() {
                System.out.println("2222");
            }
        }).start();*/
        countDownLatch.await();
        System.out.println("3333");
    }
}
