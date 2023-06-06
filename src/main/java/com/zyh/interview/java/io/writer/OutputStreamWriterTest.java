package com.zyh.interview.java.io.writer;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D://zyh.txt"), "gbk");
        osw.write("zyh, 占雨豪");
        osw.close();
    }
}
