package com.zyh.interview.java.io.outputstream;

import java.io.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream("D://object.dat");
            oos = new ObjectOutputStream(fos);
            Dog dog = new Dog("huang", "yellow");
            oos.writeObject(dog);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null)
                    oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

