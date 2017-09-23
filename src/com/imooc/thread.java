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
				
			is = socket.getInputStream();//��ȡ�ֽ���
			isr = new InputStreamReader(is);//תΪ�ַ���
			br = new BufferedReader(isr);//����������
			while ((info = br.readLine())!=null){
				System.out.println("���Ƿ��������ͻ���˵��"+ info);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.shutdownInput();//�ر�������
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
