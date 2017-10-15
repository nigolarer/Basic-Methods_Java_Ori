package intv.method.sorts;
/*
* 希尔排序
* */
public class ShellSortingTest {
    static void ShellSort(int a[], int n)
    {
        int step = n/2-1;
        while (step >= 1)
        {
            for (int i = step; i < n; i++)
            {
                int j = i - step;
                int get = a[i];
                while (j >= 0 && a[j] > get)
                {
                    a[j + step] = a[j];
                    j = j - step;
                }
                a[j + step] = get;
               showString(a);
            }
            System.out.println("step is "+step);
            step = step/2;                    // 递减增量
        }
    }

    private static void showString(int[] a) {
        for (int iter : a) {
            System.out.print(""+iter+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {5, 2, 9, 4, 7, 6, 1, 3, 8};// 从小到大希尔排序
        //ShellSort(a,a.length);
        shellSort(a);
        //showString(a);
    }

    /*
    * 自己尝试实现,最简单的希尔排序,加上while三层循环
    */
    private static void shellSort(int[] a) {
        int len = a.length;
        int step = len/2;//自定义一个步长
        while (step >= 1) {//只要步长大于一,就根据当前步长来做一次插入排序
            for(int i = 0;i<step;i++) {//进入插入排序过程
                for(int j = step + i;j<len ;j = j + step) {
                    if (a[j] < a[j - step]) {
                        int temp = a[j];
                        int pos = j - step;
                        while (pos >= 0 && a[pos] > temp) {
                            a[pos + step] = a[pos];
                            pos = pos - step;
                        }
                        a[pos + step] = temp;
                    }
                }
            }

            step = step/2;
        }
        showString(a);
    }
}

