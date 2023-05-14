package com.zyh.interview.java.io.inputstream;


import com.zyh.interview.java.io.outputstream.Dog;

import java.io.*;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("D://object.dat");
            ois = new ObjectInputStream(fis);
            try {
                Object object = ois.readObject();
                Dog dog = (Dog) object;
                System.out.println(dog);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
