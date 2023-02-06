/**
 * @author zhanyuhao
 * @time 2023/2/3 8:50
 */
package com.zyh.interview.java.collections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MapInterview {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1 map的初试化容量
        mapInitCapacity();

        //2 元素存放在Map中的位置
        //假设容量为16，也就是数组长度为16 Map的扰动函数(hash函数)的取值范围是[-2147483648, 2147483647]
        //数组下标的计算方法是
        int hash = 1025;
        int n = 16;
        int pos = (n - 1) & hash;
        System.out.println("插入的位置是：" + pos);
        /**
         * 计算原理：
         * 1025 : 10000000001
         *   15 : 00000001111
         *   按位与
         *        00000000001
         * 等于 1
         */






    }

    private static void mapInitCapacity() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        HashMap<String, Integer> map = new HashMap<>(10);

        Class<?> mapType = map.getClass();


        Method capacity = mapType.getDeclaredMethod("capacity");

        capacity.setAccessible(true);
        System.out.println("容量："+capacity.invoke(map)+" 元素数量："+map.size());
    }
}
