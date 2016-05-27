package concurrent;

import java.util.concurrent.ExecutionException;

/**
 * Created by lizhitao on 16-5-27.
 */
public class SubmitTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//
//        long begin = System.currentTimeMillis();
//
//        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                Thread.sleep(1000);
//                System.out.println("执行1");
//                return 1;
//            }
//        });
//
//        Future<Integer> future2 = threadPool.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                Thread.sleep(1000);
//                System.out.println("执行2");
//                return 2;
//            }
//        });
//
//
//        System.out.println(future.get() + future2.get());
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - begin) + " 毫秒");
//
//        threadPool.shutdown();


        CalThread calThread = new CalThread(3, 5, new Callback<Integer>() {
            public Integer callback(Integer result) {
                System.out.println(result);
                return result;
            }
        });
        new Thread(calThread).start();


    }


    private static class CalThread implements Runnable {
        private Integer result;
        private Integer a;
        private Integer b;
        private Callback<Integer> callback;

        public CalThread(Integer a, Integer b, Callback<Integer> callback) {
            this.a = a;
            this.b = b;
            this.callback = callback;
        }

        public void run() {
            this.result = this.a + this.b;
            this.callback.callback(this.result);
        }
    }

    private interface Callback<T>{
        T callback(T result);
    }
}
