# Java面试代码仓库

    包含算法面试题的求解和一些八股文的代码理解

# 1 数组相关问题
array面试题中的常见思路
## 1 常见的排序算法;
快排的分区算法，归并的merge算法，桶排序算法的入桶算法
## 2 双指针
### 2.1 对撞指针

### 2.2 滑动窗口
    题目关键词 ： 连续 子数组 子串

# 2 查找相关问题
    set

    map

L202 happy number
L290 word pattern
L205
L451

-------
L1 two sum
无序（之前有序的话用对撞指针）
> 先查询i能不能和之前插入到map中数据组合成一个结果 ----解决数组中含两个相同的元素的问题
> 直到遍历完数组，结束

L15 three sum
> 注意排序配合set去重的技巧
> 排序保证了结果的有序性， 再加上去重，才能实现真正的去重

L18 four sum
> 和L15一样的思路

L16 3sum closest
注意：可能不需要查找表
> 找两个数之和最接近target的最快方法是排序后加对撞指针
> 和找等于target不同的是，只有两个数之和更接近target的时候才更新。

------
L454 4sumII
> A + B 的所有可能放入map, C + D 的所有可能去map中查找有无，有！那是几个？

L49 Group Anagrams
> 掌握字符串如何快速排序
```java
char[] chars = strs[i].toCharArray();
Arrays.sort(chars);
``` 
------
L447 回旋镖的数量
> 求数组中两两之间的距离相等的个数 {distance :  number}
> 如果是1说明距离为distance的只有1个，那么不可能找到两个
> 如果是2说明距离为distance的有2个，那么可以找到2 * 1个（i,j,k）使得dis(i,j) = dis(i,k)
> 如果是3说明距离为distance的有3个，那么可以找到3 * 2个（i,j,k）使得dis(i,j) = dis(i,k)
> ....
> 考虑顺序，这是排列问题，而不是组合问题

L149 直线上最多的点数
```java
        Double zero1 = 0.0D;
        Double zero2 = -0.0D;
        System.out.println(zero1==zero2); // false
        System.out.println(zero1.equals(zero2)); // false
        System.out.println(zero1.equals(zero2)); // false

        System.out.println(zero1.doubleValue() == zero2.doubleValue()); //true
```

统计任意两点之间的斜率，在一条直线上最多的点，说明斜率相等的个数最多。

------
L219 存在重复元素II
> 是一个滑动窗口加查找表问题
> 保持一个[l, l+k]长度的区间，在这个区间相等的元素一定满足索引之间的距离差小于等于k
> 如果没有相等元素的话，那么检查l+k+1是否在[l+1, l+k]中存在重复元素，
> 如果有，直接返回true
> 如果没有，有移区间变成[l+1,l+k+1], 直到区间的有边界超出了数组长度

L3 无重复字符的最长子串
> 滑动窗口 + set
> r不断右移，当出现重复的字符，不断移动l, 直至不出现重复为止

L217 存在重复元素
> so easy 
 
------ 
L220 存在重复元素 III
与 L219 结合起来看
> 是一个滑动窗口加查找表问题
> 保持一个[l, l+k]长度的区间，在这个区间相等的元素一定满足索引之间的距离差小于等于k
> 使用一种能快速查询的数据结构, 在这个区间找到一个数， 这个数大于v-t且小于v+t的
> TreeSet的ceiling(v-t)返回值 < v+t

TreeSet接口的方法记忆 
> ceiling(val) ceiling天花板 -> 在上面 -> **大于**val的最小元素
> floor(val) floor地板  -> 在下面 -> **小于**val的最大元素

# 2 查找问题总结
## 技巧：
1. 给二维数组去重，二维数组中不能有一样的数组
> 排序保证了结果的有序性， 再加上去重，才能实现真正的去重
2. 找两个数之和最接近target的方式
> 找两个数之和最接近target的最快方法是排序后加对撞指针
> 和找等于target不同的是，只有两个数之和更接近target的时候才更新。
3. 掌握字符串如何快速排序
```java
char[] chs = str.toCharArray();
Arrays.sort(chs);
```
4. 组合数和排列数的求解公式
> 排列数 n! / (n-m)! 
> 组合数 n！/ (m! * (n-m)!)

## 查找问题也会和滑动窗口结合
1. TreeSet接口的方法记忆
> ceiling(val) ceiling天花板 -> 在上面 -> **大于**val的最小元素
> floor(val) floor地板  -> 在下面 -> **小于**val的最大元素




# 链表问题
链表考察的问题，一般都不能修改链表的值，而是操作链表的节点
## 常规问题
L206 反转链表
> pre cur next 三个指针
> 1. cur.next = pre //反转
> 2. pre = cur
> 3. cur = next

L83 在链表中移除重复元素
> pre.next = cur.next;
> cur = cur.next;

L86 列表元素分区
> 链表的考点， 哨兵节点+虚拟节点+链表指针的移动

L328 奇偶链表
> 和上一题一模一样的思路甚至是代码

L2 链表数字相加
> 注意进位

L445 链表数字相加II
不能修改链表结构， 使用辅助的数据结构

## *设立链表的虚拟头结点
虚拟头结点的设置方式
```java
ListNode dummyHead = new ListNode();
dummyHead.next = head;
```
最后为了方便快速释放内存
```java
ListNode retNode = dummyHead.next;
dummyHead = null;
return retNode;
```

L203 在链表中删除val的节点


L82 在链表中删除重复的节点

L21 合并两个有序链表

## 复杂的穿针引线
多设置一点 节点变量

L24  两两交换链表中的节点
> 设置虚拟节点, 四个指针

L25


L147 对链表进行插入排序


L148

## 不仅仅是穿针引线
有时候只能靠修改值才能完成任务

L237

## 链表与双指针

L19 删除链表的倒数第 N 个结点
> 两个指针，一个指针多走n步

L61 


L143
如何快速获得链表的中间元素

L234
如何快速获得链表的中间元素

## 快慢指针
L141 环形链表
> 一个slow指针走1步， 一个fast指针走2两步
> slow == fast说明有环， 
> slow或者fast能走到null, 说明无环
> 另外，环的位置

# 3 链表问题总结：
## 经典问题：
虚拟头节点迭代，尤其删除节点的时候
反转单链表
删除单链表的倒数第N个节点
判断是否是环形链表，并返回入口节点
> 1. 可以用hashSet保存节点，遇到相同的节点就以及说明有环而且，这个节点就是环的入口
> 2. 再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 **slow**
     每次向后移动一个位置。最终，它们会在入环点相遇。 

## 技巧
虚拟头
双指针
快慢指针



# stack 栈问题
L20 合法的括号

L150 逆波兰表达式
逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
逆波兰表达式主要有以下两个优点：
去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
> 注意val1 val2的位置

L71 unix路径简化

L144 二叉树的前序遍历的非递归写法
```java
class Command {
   String order; // print or go
   TreeNode node; // current node
}
```

L145 二叉树的后序遍历的非递归写法
easy
L94 二叉树的中序遍历的非递归写法
easy

L341

# queue问题
L102 树的层序遍历
> 在数据结构中有演示
```java
class Node {
   TreeNode treeNode;
   int level;
}
```

L107
Collections.reverse(res);

L103
奇数的
Collections.reverse(res);

L199
层序遍历， 取最后一个元素

图的BFS
L279
> 构建图， 5的下一个状态是4（减去1的平方）或者1（减去2的平方）
> 那么5到4的最短距离就是1， 到1的最短距离就是1
> 4的下一个状态是3（减去1的平方）或者0（减去2的平方）
> 那么5到3的最短距离就是2（5->4->3）， 到0的最短距离就是2（5->4->0）

L127
需要建图，依据朴素的思路，我们可以枚举每一对单词的组合，判断它们是否恰好相差一个字符，以判断这两个单词对应的节点是否能够相连。但是这样效率太低，我们可以优化建图。

具体地，我们可以创建虚拟节点。对于单词 hit，我们创建三个虚拟节点 *it、h*t、hi*，并让 hit 向这三个虚拟节点分别连一条边即可。如果一个单词能够转化为 hit，那么该单词必然会连接到这三个虚拟节点之一。对于每一个单词，我们枚举它连接到的虚拟节点，把该单词对应的 id 与这些虚拟节点对应的 id 相连即可。

最后我们将起点加入队列开始广度优先搜索，当搜索到终点时，我们就找到了最短路径的长度。注意因为添加了虚拟节点，所以我们得到的距离为实际最短路径长度的两倍。同时我们并未计算起点对答案的贡献，所以我们应当返回距离的一半再加一的结果。

L126
记录最短路径——经典
> ** Map<下一个节点，当前节点> 方便快速找到下一个节点是从哪个节点来的 **


## 优先队列
用一个数组实现堆
调研PriorityQueue的API, 随机插入10个数字，并取出，看是最大堆还是最小堆
> 小顶堆， 小的在上面就是小顶堆
> [1, 3, 6, 5, 4, 2] -> [1,2,3,4,5,6]

利用Comparator实现最大堆
**compare函数中两个参数位置的记忆方法**：
> o1 - o2  1,2 所以是升序
> o2 - o1  2,1 所以是降序
```java
new Comparator<Integer>() {
     @Override
     public int compare(Integer o1, Integer o2) {
        return o2 - o1;
     }
}
```
> 大顶堆， 大的在上面就是大顶堆
> [1, 3, 6, 5, 4, 2] -> [6,5,4,3,2,1]

使用PriorityQueue实现数字按个位数排序
```java
public static void main(String[] args) {
   PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
       @Override
       public int compare(Integer o1, Integer o2) {
           return o1 % 10 - o2 % 10;
       }
   });
   int[] nums = new int[]{51, 93, 66, 85, 14, 12};
   for (int i = 0; i < nums.length; i++) {
       queue.add(nums[i]);
   }
   while (!queue.isEmpty()){
       Integer poll = queue.poll();
       System.out.print(poll + ",");
   }
}
```
输出：
```51,12,93,14,85,66```
L347
PriorityQueue传入的是比较器Comparator
如果不想传，那么添加元素的类型必须是可比较的，
如果是自定义的类， 必须实现Comparable接口

L23

# 二叉树和递归
L104 二叉树的最大深度

L111 二叉树的最小深度
**注意递归的终止条件**
```java
题目求解的答案必须到叶子节点的话
if (root.left == null && root.right == null)
    return xxxx; // 递归的终止条件之一
        
因为使用了root.xxxx 所以root不能为null
那么之前还需要加上另外一个终止条件
if(root == null)
    return xxxx;
```

> 可以把一些特俗情况先判断了，然后编写一个XXXCore函数，在XXXCore递归函数中完成一般情况

L226  翻转二叉树

L100  相同的树

L101 对称二叉树


L222 完全二叉树的节点个数
可以写一个求任何一颗二叉树的节点



L110 判断平衡二叉树
> 设置私有变量
> private boolean res;


L112 路径总和
> 注意递归的终止条件
> 1. 如果强调了必须终止在叶子节点，那么应该判断 
```java
if(node.left == null && node.right == null)
     return;
```
> 2. 如果没有强调叶子节点，那么终止条件应该判断
```java
if(node == null)
     return;
```
# 稍复杂的递归逻辑
L257 二叉树的所有路径
> ** 递归问题中， 如果有返回值 **
> 思考问题的方式是：拿到左子树的返回值怎么做？拿到右子树的返回值又该怎么做？

L113 路径总和 II
** 递归中保留结果的方式 **
比如： 函数需要返回List<List<Integer>>
> 设置外部私有变量， 
```java
private List<List<Integer>> res = new ArrayList();
```
并且在辅助方法上加上一个`List<Integer>`类型的参数，保留递归时候的结果
在退出条件的时候，如果找到了一个满足题意得答案，就添加到res中，
这类问题，还需要回溯.
一个模板代码
```java
private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        List<Integer> list = new ArrayList<>();
        pathSumCore(root, targetSum, list);
        return res;
    }

    private void pathSumCore(TreeNode root, int targetSum, List<Integer> list) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        pathSumCore(root.left, targetSum - root.val, list);
        pathSumCore(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
```
L129 求根节点到叶节点数字之和

> 套用上面得模板即可

# 更复杂的递归逻辑
L437


# 二分搜索树
L235 二叉搜索树的最近公共祖先


L98 验证二叉搜索树


L450 删除二叉搜索树中的节点
> 分类讨论
> 如果目标节点大于当前节点值，则去右子树中删除；
如果目标节点小于当前节点值，则去左子树中删除；
如果目标节点就是当前节点，分为以下三种情况：
其无左子：其右子顶替其位置，删除了该节点；
其无右子：其左子顶替其位置，删除了该节点；
其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。

L108 将有序数组转换为二叉搜索树
> 二分搜索的逆过程

L230
partition


L236

# 5. 树的问题总结
1. **题目强调必须到叶子节点才符合题意。**
```java
/* 因为，叶子节点已经判断了，所以不会出现root的两边都是空的情况，
那出现root == null的情况是root只有一个孩子节点，下次递归的时候就会走到root==null
那么，应该思考这种情况的退出条件是什么。
 */
if(root == null)
    return xxxx; //因为使用了root.left/right 所以root不能为null 
if (root.left == null && root.right == null)
    return xxxx; // 递归的终止条件之一
```

2. **需要重新写一个递归函数的题目**
> 可以把一些特俗情况先判断了，然后编写一个XXXCore函数，在XXXCore递归函数中完成一般情况

3. **递归问题中， 如果有返回值** 
>思考问题的方式是：拿到左子树的返回值怎么做？拿到右子树的返回值又该怎么做？

4. **保留递归中结果的方式**
比如： 函数需要返回List<List>
> 1. 设置外部私有变量
```java
private List<List<Integer>> res = new ArrayList();
```

用于 保存所有递归终止位置的结果， 也就是所有符合题意得结果。

> 2. 并且在辅助方法上加上一个List<Integer>类型的参数，保留递归时候的结果


在退出条件的时候，如果找到了一个满足题意得答案，就添加到res中， 
这类问题，还需要回溯. 一个模板代码。


```java
/* 求根节点到叶子节点路径元素之和等于target的路径 */
private List<List<Integer>> res = new ArrayList<>();

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
   if (root == null)
       return res;
   List<Integer> list = new ArrayList<>();
   pathSumCore(root, targetSum, list);
   return res;
}

private void pathSumCore(TreeNode root, int targetSum, List<Integer> list) {
   if(root == null)
       return;
   if(root.left == null && root.right == null){
       if(root.val == targetSum){
           list.add(root.val);
           res.add(new ArrayList<>(list));
           list.remove(list.size() - 1);
       }
       return;
   }
   list.add(root.val);
   pathSumCore(root.left, targetSum - root.val, list);
   pathSumCore(root.right, targetSum - root.val, list);
   list.remove(list.size() - 1);
}
```
5. dfs
比如： 求二叉树的左孩子之和。


6. bfs
比如： 求二叉树的右视图
其实就是二叉树的层序遍历，取每一层的最后一个元素即可。


# *递归和回溯法
## 树形问题
L17 电话号码的字母组合

树形问题递归就是从节点发散出去多条线
一般就是在循环中递归， 循环的对象就是发散出去的元素组成的列表。
如果需要知道到每个结点的结果——在递归上加一个参数。
这个参数是非引用类型的，不需要回溯
这个参数是引用类型的，会影响其他节点上的结果， 因此，需要回溯

> 字符串在本次递归不想被修改，应该在递归函数中 s + letters[i]
> 如果在递归函数外部加上s += letters[i]， 再传入递归函数中, 此时还需要回溯。



L93 ip地址

怎么实现剪枝

递归前加上if, 只有满足条件的才往下面走

```java
if(check()){
    recursion().....    
}
```


L131 分割回文串

上面的模板



##  树形问题————排列问题
L46

全排列是很多问题的暴力解法
本质也是一种树形问题————套用树形问题的模板
> 1. 设置类的私有属性res
> 2. 编写辅助递归函数，确定函数的参数，（一般需要加上res的元素的所属类型,如下例子）
```java
private List<List<String>> res;
XXXCore(xx xx, List<String> list);
```
> 3. 树形问题递归就是从节点发散出去多条线， 一般就是在循环中递归， 循环的对象就是发散出去的元素组成的列表。
> 4. 这个参数是非引用类型的，不需要回溯。 
>    这个参数是引用类型的，会影响其他节点上的结果， 因此，需要回溯


L47



##  树形问题————组合问题
L77



L39



L40



L216



##  树形问题————子集问题
L78



L90



L401



## 二维平面上使用回溯法
L79



## 二维平面上使用回溯法——floodfill算法
L200



L130



L417



## 二维平面搜索问题
L51



L52



L37













