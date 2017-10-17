package codinginterviewjava.chapter5;
/*
* mxn的矩阵,数字代表礼物价值,从天左上角开始往右下角移动,每次移动一格,只能往下或者往右,求最大值是多少?
* 这里首先看到要求的是最大价值而不是路线.
* 由于是矩阵,最大价值由横纵坐标两个维度决定的,所以函数是和行与列,即i,j相关的
* f(i,j) = max{f(i,j-1),f(i-1,j)}+V(i,j)
* 这里公式很简单,到达node[i,j]的最大值等于到达他左边的节点和上方节点的中的最大值并加上该节点自己的值
* 不过这里需要注意的是临界的问题.我自己写的时候就搞蒙了
* 比如f(i,j-1)这里j-1>=0,i>=0;而f(i-1,j)则是i-1>=0,j>0;这里需要分别判断
*
* */
@SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
public class GetGiftMaxValue_47 {
    public static void main(String[] args) {
        //giftMatrix
        int[][] giftM=  {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}
        };
       // int maxValue = getGiftMaxValue(giftM,giftM.length-1,giftM[0].length-1 );
       // System.out.println("maxValue is "+ maxValue);
        int[][] note = new int[giftM.length][giftM[0].length];
        int maxValue2 = getGiftMaxValueWithNote(giftM,giftM.length-1,giftM[0].length-1,note);
        System.out.println("maxValue2 is "+ maxValue2);
        int maxValue3 = getGiftMaxValueWithNotev2(giftM,giftM.length-1,giftM[0].length-1,note);
        System.out.println("maxValue3 is "+ maxValue3);
    }


    /*
    * 整理思路:
    * 最原始的所谓的动态规划,其实就是递归版本而已
    * 从最后一个点开始递归的算出所有路径的值,并求出最大的来
    *
    *
    * */
    private static int getGiftMaxValue(int[][] giftM,int row,int col) {
        System.out.println("row is "+row+" col is"+ col);
        if (giftM == null||col<0||row<0) {//异常处理
            return 0;
        }
        if (col == 0 && row == 0) {//返回条件
            return giftM[row][col];
        }
        int maxValue = 0;
        int left = 0;
        int top = 0;
        if(col>0) {//到达当前节点的左节点的最大值,这里由于不操作row上面有小于等于0的过滤,所以不会有row越界问题,下面的col同理
            left = getGiftMaxValue(giftM, row, col-1);
        }
        if (row > 0) {//到达当前节点的上方结点的最大值
            top = getGiftMaxValue(giftM, row - 1, col);
        }
        if (left > top) {//比较大小后返回最大的那个加上当前节点的值,就是到达当前结点的最大值
            maxValue = left + giftM[row][col];
        } else {
            maxValue = top + giftM[row][col];
        }
        return maxValue;
    }

    /*
    *
    * 动态规划备忘录版本v1 很糟糕的版本
    * 这里虽然添加了备忘录,但是实际测试备忘录几乎没有被被使用过,而且还浪费了辅助空间
    * 为什么没被使用,是很糟糕的版本呢?因为这个方法是从最后一个节点向出发点递归的
    * 每次进入递归体内会先检查一下是不是有备忘录,然后再向上递归,显然,所有的节点几乎
    * 在刚开始都查不到备忘录的.因而向上层层递归,直到第一个递归体递归到起始点并更新了
    * 备忘录,此时,由于它是递归上来的,递归函数已经生成了,其他的递归函数已经错过了查备
    * 忘录的位置,所以他们也还是会继续重复递归上来
    * 比如,最后一个节点先查了备忘录为空,然后left方向向起始点递归,并且更新了起始点备
    * 忘录值,left结束.top此时也向起始点递归,同样会更新到起始点,并重新覆盖一次备忘录
    * 对应的起始点的值,而没有使用到备忘录,所以这是很糟糕的版本,赔了夫人又折兵
    *
    * */

    private static int getGiftMaxValueWithNote(int[][] giftM, int row, int col, int[][] note) {
        int maxVal = 0;
        if (giftM == null || row < 0 || col < 0) {
            return 0;
        }
        if (note[row][col] != 0) {
            System.out.println("read note:row "+row+" col "+col);
            return note[row][col];
        }

        if (row == 0 && col == 0) {
            return giftM[row][col];
        }
        int left = 0;
        int top = 0;
        if (row > 0) {
            left = getGiftMaxValueWithNote(giftM, row - 1, col, note);
            //note[row-1][col] = left;
        }
        if (col > 0) {
            top = getGiftMaxValueWithNote(giftM, row, col - 1, note);
            //note[row][col] = top;
        }
        if (left > top) {
            note[row][col] = left + giftM[row][col];
            return note[row][col];
        } else {
            note[row][col] = top + giftM[row][col];
            return note[row][col];
        }
    }
    /*
    * 动态规划备忘录版本v2
    *
    * */
    private static int getGiftMaxValueWithNotev2(int[][] giftM, int row, int col, int[][] note) {
        int maxVal = 0;
        if (giftM == null || row < 0 || col < 0) {
            return 0;
        }
        return 0;
    }

}
