package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverThread {
/**
 * ����TCP��Socketͨ�ŵ�������
 * 
 */
	public static void main(String[] args) {
		try {
			//������������socket��ָ���˿�
			ServerSocket serverSocket = new ServerSocket(8888);//���ڽ�����ѭ��������ServerSocket����Ҫ�ر�Ҳִ�в����ر���һ��
			//����accept()���������˿ڣ��ȴ��ͻ��˵�����
			System.out.println("�����������������ȴ����ӣ�");
			int count = 0;
			Socket socket = null;
			while(true){
				socket = serverSocket.accept();
				new thread(socket).start();
				count++;
				System.out.println("�ͻ�������Ϊ��" + count);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

