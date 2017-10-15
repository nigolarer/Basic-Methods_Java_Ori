package intv.method.sorts;
/*
* 选择排序
* 从第一个元素位开始，每次选取剩余元素中最小的元素放在这个位置
* 该位置的元素与最小的元素互换，一趟交换完成
*
* 注意选择排序与冒泡排序的区别：冒泡排序通过依次交换相邻两个顺序不合法的元素位置，
* 从而将当前最小（大）元素放到合适的位置；
* 而选择排序每遍历一次都记住了当前最小（大）元素的位置，最后仅需一次交换操作即可
* 将其放到合适的位置。
*
* */
public class SelectionSortingTest {
    public static void main(String[] args) {
        int []a = {5,1,4,8,41,5,1,3,4,31,6,4,8,41,74,61,7,89,7,2};
        showResult(a);
        doSelectionSort(a);
        showResult(a);
    }

    private static void doSelectionSort(int[] a) {
        int tempMin;
        int tempMinPos;
        int temp;
        for(int i  = 0 ;i<a.length;i++) {
            tempMin = a[i];
            tempMinPos = i;
            for(int j = i;j<a.length;j++) {
                if (a[j] < tempMin) {
                       tempMin = a[j];
                       tempMinPos = j;
                }
            }
            System.out.println("min is "+a[tempMinPos]+" its right position is "+ i);
            temp = a[i];
            a[i] = a[tempMinPos];
            a[tempMinPos] = temp;
        }
    }

    private static void showResult(int[] a) {

        for (int iterator : a) {
            System.out.print(iterator+" ");
        }

    }
}
