# Java面试代码仓库

    包含算法面试题的求解和一些八股文的代码理解

# 1 数组相关问题


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
