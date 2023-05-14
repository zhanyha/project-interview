package com.zyh.interview.java.io.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: FileWriterTest
 * @author：zhanyh
 * @date: 2023/5/12
 */
public class FileWriterTest {
    public static void main(String[] args) {
        try {
            FileWriter fr = new FileWriter("D://zyh.txt");
            String data = "hello,world FileWriterTest";
            fr.write(data.toCharArray());
            fr.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

        }

    }
}
