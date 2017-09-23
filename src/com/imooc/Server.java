package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
/**
 * ����TCP��Socketͨ�ŵ�������
 * 
 */
	public static void main(String[] args) {
		try {
			//������������socket��ָ���˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			//����accept()���������˿ڣ��ȴ��ͻ��˵�����
			System.out.println("�����������������ȴ����ӣ�");
			Socket socket = serverSocket.accept();
			//��ȡ���������õ��ͻ��˵���Ϣ
			InputStream is = socket.getInputStream();//��ȡ�ֽ���
			InputStreamReader isr = new InputStreamReader(is);//תΪ�ַ���
			BufferedReader br = new BufferedReader(isr);//����������
			String info = null;
			while ((info = br.readLine())!=null){
				System.out.println("���Ƿ��������ͻ���˵��"+ info);
			}
			socket.shutdownInput();//�ر�������
			//�ر���Դ
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
