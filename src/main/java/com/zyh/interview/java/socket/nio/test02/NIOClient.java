package com.zyh.interview.java.socket.nio.test02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/15
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("127.0.0.1", 8080));
        //sc.write(StandardCharsets.UTF_8.encode("hello,world!"));
        System.out.println("waiting...");
    }
}
