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

L126
记录最短路径——经典

## 优先队列
用一个数组实现堆
调研PriorityQueue的API, 随机插入10个数字，并取出，看是最大堆还是最小堆
Compartor

使用PriorityQueue实现数字按个位数排序

L347


L23

# 二叉树和递归

L104


L111

L226

L100

L101

L222
可以写一个求任何一颗二叉树的节点
但是求完全二叉树有更快的方法，满二叉树的有转满快速求出、

L110 Balanced Binary Tree

L112 Path Sum
> 注意递归的终止条件

L404

## 稍复杂的递归逻辑
L257


L113

L129




















