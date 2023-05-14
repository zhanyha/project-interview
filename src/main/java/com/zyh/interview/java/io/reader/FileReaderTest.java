package com.zyh.interview.java.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description: FileReaderTest
 * @author：zhanyh
 * @date: 2023/5/12
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("D://zyh.txt");
            int readData = 0;
            char[] cache = new char[8];
            while (readData != -1) {
                readData = fr.read(cache);
                if(readData != -1)
                    System.out.print(new String(cache, 0 , readData));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
