package com.imooc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientThread {

	public static void main(String[] args) {
		try {
			//����socket
			Socket socket = new Socket("localhost", 8888);
			//��ȡ�����
			OutputStream os = socket.getOutputStream();//�ֽ���
			OutputStreamWriter osw = new OutputStreamWriter(os);//�ַ���
			osw.write("�û�����wenyer-----���룺12345");
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
