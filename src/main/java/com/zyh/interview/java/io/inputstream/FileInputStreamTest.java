package com.zyh.interview.java.io.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/12
 * d://zyh.txt : hello,world!
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        String path = "d://zyh.txt";
        FileInputStream fs = null;
        int data;
        try {
            fs = new FileInputStream(path);
            while ((data = fs.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(fs != null)
                    fs.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
