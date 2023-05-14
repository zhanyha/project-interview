package com.zyh.interview.java.io.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: FileOutputStreamTest
 * @author：zhanyh
 * @date: 2023/5/12
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D://zyh02.txt");
            String str = "hello, world";
            fos.write(str.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
