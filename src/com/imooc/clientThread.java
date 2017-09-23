package com.imooc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientThread {

	public static void main(String[] args) {
		try {
			//创建socket
			Socket socket = new Socket("localhost", 8888);
			//获取输出流
			OutputStream os = socket.getOutputStream();//字节流
			OutputStreamWriter osw = new OutputStreamWriter(os);//字符流
			osw.write("用户名：wenyer-----密码：12345");
			osw.flush();
			socket.shutdownOutput();
			osw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
