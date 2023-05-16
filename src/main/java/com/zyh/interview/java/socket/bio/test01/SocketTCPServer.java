package com.zyh.interview.java.socket.bio.test01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        // 1. 监听本地端口9999
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2. 接收客户端请求
        Socket socket = serverSocket.accept();
        // 3. 接收客户端发来的数据（是字节流）
        InputStream is = socket.getInputStream();
        byte[] buff = new byte[1024];
        int dataLen;
        while ((dataLen = is.read(buff)) != -1) {
            System.out.print(new String(buff, 0, dataLen, "gbk"));
        }
        System.out.println();
        is.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端关闭！");
    }
}
