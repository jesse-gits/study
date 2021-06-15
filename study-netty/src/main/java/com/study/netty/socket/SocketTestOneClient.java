package com.study.netty.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTestOneClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 777);

            //读取服务器端数据
            DataInputStream input = new DataInputStream(socket.getInputStream());
            //向服务器端发送数据
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.print("请输入: \t");
            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
            out.writeUTF(str);

            String ret = input.readUTF();
            System.out.println("服务器端返回过来的是: " + ret);
            // 如接收到 "OK" 则断开连接
            if ("OK".equals(ret)) {
                System.out.println("客户端将关闭连接");
                Thread.sleep(500);
               return;
            }

            out.close();
            input.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
