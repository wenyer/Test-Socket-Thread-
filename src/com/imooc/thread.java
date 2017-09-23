package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class thread extends Thread {
	Socket socket = null;
	public thread(Socket socket){
		this.socket = socket;
	}
	public void run(){
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String info = null;
		try {
				
			is = socket.getInputStream();//获取字节流
			isr = new InputStreamReader(is);//转为字符流
			br = new BufferedReader(isr);//创建缓冲区
			while ((info = br.readLine())!=null){
				System.out.println("我是服务器，客户端说："+ info);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.shutdownInput();//关闭输入流
				br.close();
				isr.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
