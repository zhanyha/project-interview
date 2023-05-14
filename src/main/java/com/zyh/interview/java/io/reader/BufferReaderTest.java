package com.zyh.interview.java.io.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/12
 */
public class BufferReaderTest {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("D://zyh.txt");
            br = new BufferedReader(fr);
            String line = "";
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
