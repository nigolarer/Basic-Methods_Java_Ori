package intv.method.sorts;
/*
* 插入排序
* 所谓假定第一个为有序的,从后面的第一位开始扫描,将它放入有序的队列中的正确位置上
* 放入正确的位置上时,需要一个个的交换直到交换到正确位置为止(冒泡)
* 这里也可以不用一一比较交换,可以先记录K值,然后比较,直到找到位置n后前一个赋给后一个总共进行pos-n次
* 然后将记录的k值放到n完成交换(可以参考希尔排序里的内置插入排序部分)
*
* 二分插入排序:
* 这里主题思想不变,只是通过二分法定位到新元素需要放置的位置,然后再位移放入而不是逐个比较的放入
* 即,直接插入排序用的是冒泡法来将新元素插入到有序数组而二分法是先定位然后再插入
* 不过元素还是需要一个一个的向后移动,只是移动的时候不需要比较了.
* */
public class InsertionSortingTest {
    public static void main(String[] args) {
        //int a[] = {1, 5, 3, 4, 77, 46, 9, 9, 94, 496, 6, 1};
        int b[] = {1, 5, 3, 4, 77, 46, 9, 9, 94, 496, 6, 1};
        //StraightInsertFunc(a);//直接插入排序
        BinaryInsertFunc(b);//二分插入排序
    }

    private static void BinaryInsertFunc(int[] b) {
        int low,high,mid;
        int temp = 0;
        for(int i = 1;i<b.length;i++) {
            low = 0;
            high = i-1;
            mid = (low+high)/2;
            while(low <= high){
                System.out.println("do while low is "+low+" high is "+ high + " mid is "+ mid);
                if (b[i] > b[mid]) {
                    low = mid + 1;
                } else if (b[i] <= b[mid]) {
                    high = mid - 1;
                }
                mid = (low+high)/2;
            }
            temp = b[i];
            for(int j = i; j > low;j--) {
                b[j] = b[j-1];
                //b[j-1] = b[j];
                //b[j] = temp;
            }
            b[low] = temp;
            showString(b);
        }
        showString(b);
    }

    private static void showString(int[] b) {
        for (int it : b) {
            System.out.print(it+" ");
        }
        System.out.println();
    }

    private static void StraightInsertFunc(int[] a) {
        for(int i = 1;i<a.length;i++) {
            for(int j = i;j > 0 && a[j] > a[j-1] ;j-- ) {//大小判断是在这里
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;

            }
        }
        showString(a);
    }
}









