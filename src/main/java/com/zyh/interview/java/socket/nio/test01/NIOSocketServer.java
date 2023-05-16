package com.zyh.interview.java.socket.nio.test01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: NIO的 阻塞模式
 * @author：zhanyh
 * @date: 2023/5/15
 *  SocketChannel 和ServerSocketChannel是一对 他们是java.nio下面实现通信的类 支持异步通信
 */
public class NIOSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));

        List<SocketChannel> socketChannelList = new ArrayList<>();

        ByteBuffer buffer = ByteBuffer.allocate(16);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannelList.add(socketChannel);
            for (SocketChannel channel : socketChannelList) {
                channel.read(buffer); // 阻塞方法，线程停止运行
                buffer.flip();
                while(buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                System.out.println();
                buffer.clear();
            }
        }

    }
}
