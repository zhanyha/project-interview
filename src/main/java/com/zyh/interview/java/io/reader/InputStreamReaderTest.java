package com.zyh.interview.java.io.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D://zyh.txt"), "gbk");

        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
    }
}
