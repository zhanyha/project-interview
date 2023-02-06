/**
 * @author zhanyuhao
 * @time 2023/1/28 21:36
 */
package com.zyh.interview.java.base;

import java.io.IOException;

public class Exception {
    public static void main(String[] args) {
        try {
            String str = null;
            int len = str.length();

            int result = 10 / 0; // 这行代码不会执行
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }catch (ArithmeticException e) {
            System.out.println("ArithmeticException");  // 不会执行
        }finally {
            System.out.println("exec finally block");
        }
        System.out.println("outside env");

    }
    public void testException(String fileName) throws IOException {
        if(fileName == null){
            throw new IOException();
        }
        int len = fileName.length();
        System.out.println(len);
    }
}
