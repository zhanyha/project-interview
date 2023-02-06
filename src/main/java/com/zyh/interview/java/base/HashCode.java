/**
 * @author zhanyuhao
 * @time 2023/1/26 13:54
 */
package com.zyh.interview.java.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 当你把对象加入 HashSet 时，HashSet 会先计算对象的 hashCode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashCode 值作比较，
 * 如果没有相同的 hashCode，HashSet 会假设对象没有重复出现。
 * 但是如果发现有相同 hashCode 值的对象，
 * 这时会调用 equals() 方法来检查 hashCode 相等的对象是否真的相同。
 * 如果两者相同，HashSet 就不会让其加入操作成功。
 * 如果不同的话，就会重新散列到其他位置。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。
 *
 * 总结下来：
 * 元素加入Hash集合中，先看hashCode是否一样，如果一样，再看equals的返回值。决定是否加入这个元素到集合中。
 *
 * 所以： 两个对象的hashCode 值相等并不代表两个对象就相等。还要比较equals
 */

public class HashCode {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student{
        int sno;
        String name;

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            Student std = (Student)obj;
            if(this.sno != std.sno)
                return false;
            return Objects.equals(this.name, std.name);
        }

        /**
         * @return 学号作为hashCode
         */
        @Override
        public int hashCode() {
            return this.sno;
        }
    }

    public static void main(String[] args) {
        Map<Student, Integer> classes = new HashMap<>();
        Student std1 = new Student(1, "zhangsan");
        Student std2 = new Student(1, "zhangsan");
        classes.put(std1, 1);
        classes.put(std2, 2);
        // 没有重写Student的hashCode方法返回2， 但是理论需求上应该是1.
        // 重写hashCode方法后， 学号作为hashCode。 返回了1
        System.out.println(classes.size());
    }
}
