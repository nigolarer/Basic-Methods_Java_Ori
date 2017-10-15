package CodingInterviewJava.Chapter5;
/*
* 剑指offer面试题48最长不含重复字符的子字符串
* 字符串子串首先不是随便挑几个字符出来就是子字符串,而是相邻的才行比如abcd,那么ab bcd 都是而 ad则不是
* 看到字符串,看到子字符串,首先想到KMP
* 然鹅,这里并没有用到KMP算法,而采用了动态规划
* 首先,长度为n的字符串的子串数量为n(n+1)/2 + 1
* 证明:(来自百度)
* | X | X X
* 想像向 n 个字符中间插入两片木板，这两片木板之间的即为原串的一个子串。
* 总共有 n + 1 个空位可以插，第一个木板插入后，第二个还有 n 个空位。
* 所以共有 n(n+1) 种插法，又由于两片木板交换顺序后，子串还是同一个子串，
* 所以子串数量应为 n(n+1)/2 。但最后，空串是任意字符串的子串，所以最后还要 +1
* 因此O(n^2)的复杂不能忍,所以动态规划
*
* 分析:
* 动态规划该问题,分析最优解结构
* f(n)用来表示第n个字符为结尾是的子串最长长度n从0到len
*  _/ f(n) = f(n-1)+1  当第n个结点与前面所有的字符都不相等时,或者第n个节点的字符距离上一次出现它的距离大于f(n-1)时
*   \ f(n) = d         第n个节点的字符距离上一次出现它的距离小于f(n-1)时
* 实话说,这个算法对于刚开始接触动态规划的小伙伴而言很难想到,能看懂已经算不错了.慢慢习惯吧
*
*
* */
public class longestSubstringWithoutDuplication_48 {
    public static void main(String[] args) {
        String str = "arabcacfr";
        char[] charS = str.toCharArray();
        int maxLen = getLongestSubStringWithOutDuplication(charS);
        System.out.println("max length is :"+maxLen);
    }
    /*
    * 首先,用来那个个变量,一个是动态记录当前的最大子串的长度,另一个是记录历史最大子串的长度
    * 其次,定义了一个计算当前字符上次出现的位置的函数,这里并没有再申请空间,与书上不同.
    * 如果字符串很长很长那么定义一个辅助空间更划算,我这边getLastPos遍历的话还是容易O(n^2)
    * 修改getLastPos函数后的checkLastPos,申请了额外空间
    * 就可以很轻松的实现辅助空间版本,这里不再赘述.
    * 接下来,如果返回结果是-1(表明该字符之前没有在字符串中出现)或者长度大于当前最大长度(curLen),则当前最大长度自增1
    * 如果返回结果是小于当前最大长度,则覆盖当前最大长度值
    * 每一趟下来都与历史最大长度比较如果大于历史最大长度则更新它最后返回最大值
    *
    * */
    private static int getLongestSubStringWithOutDuplication(char[] charS) {
        int maxLen = 0;
        int curLen = 0;
        if (charS == null) {//非法判定
            return maxLen;
        }
        int[] position = new int[26];//这里申请额外空间来存储最后一次出现该元素的位置
        for(int i = 0;i<position.length;i++) {
            position[i] = -1;
        }
        for (int i = 0; i < charS.length; i++) {
            //int lastPos = getLastPos(charS, i);
            int lastPos = checkLastPos(charS,position,i,1);
            if (lastPos < 0 || i - lastPos > curLen) {//注意这里是大于curLen而非maxLen
                curLen++;
            }
            else{
                curLen =  i - lastPos;//计算d
            }
            if (maxLen < curLen) {
                maxLen = curLen;
            }
            checkLastPos(charS,position,i,0);//更新最后一次该元素位置
        }
        return maxLen;
    }
    /*
    * 不申请辅助空间版
    * */
    private static int getLastPos(char[] charS, int pos) {
        int lastPos = -1;
        for(int i = 0;i<pos;i++) {
            if (charS[pos] == charS[i]) {
                lastPos = i;
            }
        }
        return lastPos;
    }
    /*
    * 辅助空间版本的lastPos,direction为1时作为查询,返回lastpos
    * direction不为1时,作为更新position的lastpos
    *
    * */
    private static int checkLastPos(char[] charS, int[] position,int pos,int direction) {
        if (direction == 1) {
            return position[charS[pos]-'a'];
        } else {
            position[charS[pos]-'a'] = pos;
            return 0;
        }

    }
}
