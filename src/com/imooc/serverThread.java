package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverThread {
/**
 * 基于TCP的Socket通信的主机端
 * 
 */
	public static void main(String[] args) {
		try {
			//创建服务器端socket并指定端口
			ServerSocket serverSocket = new ServerSocket(8888);//由于进入死循环，所以ServerSocket不需要关闭也执行不到关闭那一步
			//调用accept()方法监听端口，等待客户端的连接
			System.out.println("服务器即将启动，等待连接：");
			int count = 0;
			Socket socket = null;
			while(true){
				socket = serverSocket.accept();
				new thread(socket).start();
				count++;
				System.out.println("客户端数量为：" + count);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

