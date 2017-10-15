import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
* 实现同步和锁
* 一种是addValueSync
* 另一种是addValueLock
* 他们均可以实现加锁,这里两种方式都用到了,但是这样不好,最好只是使用一种加锁不然会出问题
* */
class SyncTest{
    private int value = 0;
    Lock lock = new ReentrantLock();
    public synchronized void addValueSync(){
        this.value++;
        System.out.println(Thread.currentThread().getName()+":"+value);
    }
    public void addValueLock(){
        try {
            lock.lock();
            value++;
            System.out.println(Thread.currentThread().getName()+":"+value);
        }
        catch (Exception e) {

        }finally {
            lock.unlock();
        }

    }

}
public class LockAndSyncTest {
    public static void main(String[] args) {
        final SyncTest st = new SyncTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++){
                    st.addValueLock();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++) {
                    st.addValueSync();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
