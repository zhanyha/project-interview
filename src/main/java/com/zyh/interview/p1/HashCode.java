/**
 * @author zhanyuhao
 * @time 2023/1/26 13:54
 */
package com.zyh.interview.p1;

/**
 * 当你把对象加入 HashSet 时，HashSet 会先计算对象的 hashCode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashCode 值作比较，
 * 如果没有相符的 hashCode，HashSet 会假设对象没有重复出现。
 * 但是如果发现有相同 hashCode 值的对象，
 * 这时会调用 equals() 方法来检查 hashCode 相等的对象是否真的相同。
 * 如果两者相同，HashSet 就不会让其加入操作成功。
 * 如果不同的话，就会重新散列到其他位置。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。
 */
public class HashCode {
}
