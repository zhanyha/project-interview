package com.zyh.interview.java.socket.nio.test04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: NIO的 非阻塞模式
 * @author：zhanyh
 * @date: 2023/5/15
 * selector解决CPU空转的问题 ____处理读事件
 */
public class NIOSocketServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8080));
            serverSocketChannel.configureBlocking(false);
            // 交给Selector管理， 一旦有事件触发便会通知
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 所有事件
                selector.select();

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iter = keys.iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel sc = channel.accept();
                        System.out.println("与客户端建立连接: " + sc);
                    } else if (key.isReadable()) {

                    }
                    // 处理完毕，必须将事件移除
                    iter.remove();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
