package intv.method.basic;

import java.util.concurrent.*;

public class CallableTest {
    public static class CallableTestIn implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "Hi";
        }
    }
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // Start Thread
        Future<String> futrue = threadPool.submit(new CallableTestIn());
        try {
            System.out.println("");
            System.out.println(futrue.get());
        }catch (Exception e){

        }

    }
}
