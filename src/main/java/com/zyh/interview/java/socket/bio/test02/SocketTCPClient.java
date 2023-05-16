package com.zyh.interview.java.socket.bio.test02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description:
 * @author：zhanyh
 * @date: 2023/5/13
 */
public class SocketTCPClient {
    public static void main(String[] args) throws IOException {
        // 1.和服务端通信的 IP + port
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 2. 通过socket写入数据
        OutputStream os = socket.getOutputStream();
        // 3. 字节流到字符流包装一下， 写入文本更加方便。
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
        writer.write("hello 你好, server:9999.");
        // ！important 一定要刷
        writer.flush();
        writer.close();
        socket.close();
        System.out.println("发送完毕， 客户端关闭");
    }
}
