package intv.method.companies;

import java.util.LinkedList;
import java.util.Queue;

class BiTree{
    BiTree left;
    BiTree right;
    int value;

    BiTree(int value) {
        this.value = value;
    }

}
/**
 * @author nigolarer
 * 挖财2018笔试题,非递归计算二叉树的高度
 * 答题的时候居然写错了.这两天被IBM的智力题搞完蛋了
 *
 * 思路很简单:
 * 首先,高度就是层次数,层次就是需要队列做辅助
 * 其次,队列中将结点按层装入,通过对队首结点左右孩子的检查将他们入队(队尾)
 * 再次,重复这个过程就可以层序遍历所有节点
 *
 * 问题来了,如何判断层数呢?
 * 这里用两个变量来判断
 * 第一个变量记录当前层次的剩余节点数,第二个变量记录下一个层次的节点数
 * 如果第一个变量为0.说明该层遍历完成,下一个队首元素即是遍历下一层
 * 1.由root开始,当前层节点数1
 * 2.根据左右孩子,下一层数目从0开始自增
 * 3.某一个节点的左右孩子入队后,当前层节点数减1
 * 4.如果当前层数目为0,说明当前层已经遍历完成.此时,树的高度加1,下一层的结点总数赋给当前层,下一层结点数置0
 * 5.读取队首元素(此时为新的一层),重复2-4步,直到没有新的节点入队
 *
 *
 * */
public class BiTreeHigh {
    public static void main(String[] args) {
        BiTree root = new BiTree(0);
        BiTree n1 = new BiTree(1);
        BiTree n2 = new BiTree(2);
        BiTree n3 = new BiTree(3);
        BiTree n4 = new BiTree(4);
        BiTree n5 = new BiTree(5);
        root.left = n1;
        root.right = n5;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        int high = getTreeHigh(root);
        System.out.println(high);
    }
    /**
     * 核心算法
     *
     * */
    public static int getTreeHigh(BiTree root){
        if(root == null){
            return -1;
        }
        //这里注意队列的定义,是用linkedList来实现Queue接口的
        Queue <BiTree> queue = new LinkedList <BiTree>();
        queue.add(root);
        //树高度
        int level = 0;
        //当前层节点数,初始只有根节点,所以为1
        int currentLevelSize = queue.size();
        //下一层结点数,初始值为0
        int nextLevelSize = 0;
        while(!queue.isEmpty()){
            BiTree node = queue.peek();
            if(node.left!=null){
                queue.add(node.left);
                nextLevelSize++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextLevelSize++;
            }
            //删除队首元素
            queue.remove();
            //由于出队,当前层元素减1
            currentLevelSize--;
            /*
             * 当前层节点数为0时,表示此刻队列中存放的是且一定是下一层的所有节点了
             * 此时树高加1,下一层的结点总数赋值给当前层节点数,下一层的结点总数置
             * 空,从而进入下下一层的入队出队操作
             *
             * */
            if(currentLevelSize == 0){
                level++;
                currentLevelSize = nextLevelSize;
                nextLevelSize = 0;
            }

        }
        return level;

    }
}


