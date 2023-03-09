/**
 * @author zhanyuhao
 * @time 2023/2/7 9:23
 */
package com.zyh.interview.java.io;

import java.io.IOException;
import java.io.InputStream;

public class IOInterview {


    public static void main(String[] args) {
        InputStream is = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
    }
}
