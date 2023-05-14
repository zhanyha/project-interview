package com.zyh.interview.java.io.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/12
 */
public class BufferWriterTest {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("D://zyh.txt");
            bw = new BufferedWriter(fw);
            bw.write("hello, bufferWriter!!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
