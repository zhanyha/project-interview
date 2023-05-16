package com.zyh.interview.java.socket.nio.test02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: NIO的 非阻塞模式
 * @author：zhanyh
 * @date: 2023/5/15
 *  serverSocketChannel.configureBlocking(false);
 *  这样存在的问题是CPU一直空转。
 *  虽然没有连接请求要处理，也没有消息要处理， 但是CPU忙的停不下来。
 */
public class NIOSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));

        // 非阻塞模式， 建立连接时非阻塞的
        serverSocketChannel.configureBlocking(false);

        List<SocketChannel> socketChannelList = new ArrayList<>();

        ByteBuffer buffer = ByteBuffer.allocate(16);
        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null) {
                socketChannelList.add(socketChannel);
                System.out.println("与客户端建立连接: " + socketChannel);
                socketChannel.configureBlocking(false); // 非阻塞模式， 数据非阻塞式读取。
            }
            for (SocketChannel channel : socketChannelList) {
                channel.read(buffer); // 阻塞方法，线程停止运行
                buffer.flip();
                while(buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
            }
        }

    }
}
