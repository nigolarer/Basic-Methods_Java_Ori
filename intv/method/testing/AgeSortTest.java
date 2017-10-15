package intv.method.testing;

/*
* 对年龄数组排序
* 通过映射ages到timesOfages中再通过遍历timesOfAge来覆盖ages,实现排序
* */
public class AgeSortTest {

    public static void main(String[] args) {
        int ages[] = {41,44,11,34,78,78,4,23,47,21,37,14,8,16,7,17,53,81,7,16,74,18,23,79,4,31,3,64,8};
        int length = ages.length;
        //ageSort(ages,length);
        ageSort2(ages);
        showAges(ages,"ages[]:");
    }

    private static void ageSort2(int[] ages) {//自己实现一次
        int len = ages.length;
        int[] times = new int[99];
        for (int i = 0;i<len;i++) {//ages中出现得值作为times数组的下标来自增
            ++times[ages[i]];
        }
        int pos = 0;
        for(int i = 0;i<len;i++) {
            for(int j = 0;j<times[i];j++) {
                ages[pos] = i;
                pos++;
            }
        }
    }

    /*
    * 剑指offer P.82
    *
    * */
    private static void showAges(int[] ages,String s) {//显示数组
        System.out.println(s);
        for (int iterator : ages) {
            System.out.print(iterator+ " ");
        }
        System.out.println();
    }

    private static void ageSort(int[] ages, int length) {
        if (ages == null || length <= 0) {//非法值处理
            return;
        }
        final int maxAge = 99;//年龄从0到最大99岁
        int[] timesOfAge = new int[maxAge + 1];
        for(int i = 0;i<length;i++) {//将年龄值出现的次数映射到timesOfAge[]中
            int age = ages[i];
            if (age < 0 || age > maxAge) {//非法值处理
                return;
            }
            timesOfAge[age]++;
        }
        int index = 0;//迭代器,用来将排序号后的年龄覆盖ages[]的原年龄
        for(int i =0;i<=maxAge;i++) {
            for (int j = 0; j < timesOfAge[i]; j++) {
                ages[index] = i;
               // System.out.println(" i = "+i);
                ++ index;
            }
        }
        showAges(timesOfAge,"timesOfAge in sort");
    }
}
