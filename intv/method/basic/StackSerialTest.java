package intv.method.basic;

import java.util.Stack;

/*
* 给定一个入栈序列和一个出栈序列,要求判断出栈序列是否是入栈序列的一种可能性
*
* */
public class StackSerialTest {
    public static void main(String[] args) {
/*        Stack pop, push;
        int MaxLength = 5;
        int InitNum = 1;
        pop = new <Integer>Stack();
        push = new <Integer>Stack();
        for (int i = InitNum; i <= MaxLength; i++) {
            pop.push(i);
        }*/
        String push = "1,2,3,4,5";
        String pop = "1,2,3,4,5";
        String[] popS = pop.split(",");
        String[] pushS = push.split(",");
        showStringList("push:",pushS);
        showStringList("pop:",popS);
        System.out.println(isPopOrder(popS, pushS));
    }

    /*
    * 打印String数组
    *
    * */
    private static void showStringList(String info,String[] popS) {
        System.out.println(info+" ");
        for (String s : popS) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    /*
    * 判断序列是否正确,自己实现的版本:
    *1.创建临时栈,以输出序列为主,扫描输入序列以及临时栈顶元素,
    *2.当输出序列的值等于栈顶元素时,栈顶元素出栈
    *3.当输出序列的元素不等于栈顶元素时,扫描输入序列的元素,此时,不相等则入栈,相等则跳过这个元素的比较(等同于入临时栈再出临时栈操作)
    *  直到输入序列为空
    *4.如果扫描完输出序列后,临时栈为空则说明匹配完整,否则说明匹配不完整不是输出序列
    *
    * 缺点:一定需要扫描完整个pop才能根据栈的结果判断是否匹配
    * 改进方法:无论如何,先入栈,然后根据栈顶匹配,如果不匹配则直接在失配处得出失败的结论,不用扫描完整个栈
    * 参考剑指offer P.170
    * */
    private static boolean isPopOrder(String[] popS, String[] pushS) {
        //非法输入判断
        if (popS == null || pushS == null || popS.length != pushS.length) {
            return false;
        }
        Stack<String> tmp = new Stack <String>();//创建临时栈

        for(int i = 0,j = 0;i<popS.length;i++) {
            if (!tmp.isEmpty()&&popS[i].equals(tmp.peek())) {//与临时栈顶元素比较
                tmp.pop();
            } else {//临时栈为空或者不匹配时扫描输入序列
                while (j < pushS.length) {
                    if (!popS[i].equals(pushS[j])) {//输入序列的元素不相等时入栈
                        tmp.push(pushS[j]);
                        j++;
                    } else {//相等时,跳过当前比较,进行下一个元素的匹配,这里相当于入栈再出栈
                        j++;
                        break;
                    }
                }
            }
        }
        if (tmp.isEmpty()) {//临时栈为空则说明匹配成功,否则失败
            return true;
        } else {
            return false;
        }
    }

}

