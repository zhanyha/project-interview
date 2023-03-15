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


L18 four sum

L16 3sum closest
注意：可能不需要查找表

------
L454 4sumII
> A + B 的所有可能放入map, C + D 的所有可能去map中查找有无，有！那是几个？

L49 Group Anagrams

------
L447
> 求数组中两两之间的距离相等的个数 {distance :  number}
> 如果是1说明距离为distance的只有1个，那么不可能找到两个
> 如果是2说明距离为distance的有2个，那么可以找到2 * 1个（i,j,k）使得dis(i,j) = dis(i,k)
> 如果是3说明距离为distance的有3个，那么可以找到3 * 2个（i,j,k）使得dis(i,j) = dis(i,k)
> ....

L149


------
L219
> 是一个滑动窗口加查找表问题
> 保持一个[l, l+k]长度的区间，在这个区间相等的元素一定满足索引之间的距离差小于等于k
> 如果没有相等元素的话，那么检查l+k+1是否在[l+1, l+k]中存在重复元素，
> 如果有，保存
> 如果没有，有移区间变成[l+1,l+k+1], 直到区间的有边界超出了数组长度

L3
L217

----
L220
> 是一个滑动窗口加查找表问题
> 保持一个[l, l+k]长度的区间，在这个区间相等的元素一定满足索引之间的距离差小于等于k
> 使用一种能找到一个区间中小于某个数值num[i]+t的 最大元素 的数据结构。
> 如果区间存在这样的元素，还需要判断这个元素是否大于num[i]-t