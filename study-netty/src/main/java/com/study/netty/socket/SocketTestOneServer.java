package com.study.netty.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTestOneServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(777);
            Socket clientSocket = serverSocket.accept();
            // 读取客户端数据
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            String clientInputStr = input.readUTF();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
            // 处理客户端数据
            System.out.println("客户端发过来的内容:" + clientInputStr);

            // 向客户端回复信息
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.print("请输入:\t");
            // 发送键盘输入的一行
            String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
            out.writeUTF(s);

            out.close();
            input.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  static String processRequest(String request){
       return  "response";
    }
}
