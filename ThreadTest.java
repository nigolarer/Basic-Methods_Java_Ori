/*
*
* 线程测试
* 使用start()则先输出Hi之后,主程序继续执行,此刻线程也会执行,不会阻塞
* 可以看到,主函数先输出完了而线程sleep了一会儿才进行
*
*
* 另一方面,如果不用start而改成run,那么则run变成了一般的方法,并没有创建线程,从而变成了顺序进行
*
*
* */
public class ThreadTest extends  Thread{
    public void run(){
        try {
            Thread.sleep(100);
            System.out.println("fun run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Thread t1 = new ThreadTest();
        System.out.println("Hi");
        t1.start();
        System.out.println("Bye");
    }
}
