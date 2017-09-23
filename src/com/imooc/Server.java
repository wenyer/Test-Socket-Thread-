package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
/**
 * 基于TCP的Socket通信的主机端
 * 
 */
	public static void main(String[] args) {
		try {
			//创建服务器端socket并指定端口
			ServerSocket serverSocket = new ServerSocket(8888);
			//调用accept()方法监听端口，等待客户端的连接
			System.out.println("服务器即将启动，等待连接：");
			Socket socket = serverSocket.accept();
			//获取输入流来得到客户端的信息
			InputStream is = socket.getInputStream();//获取字节流
			InputStreamReader isr = new InputStreamReader(is);//转为字符流
			BufferedReader br = new BufferedReader(isr);//创建缓冲区
			String info = null;
			while ((info = br.readLine())!=null){
				System.out.println("我是服务器，客户端说："+ info);
			}
			socket.shutdownInput();//关闭输入流
			//关闭资源
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
