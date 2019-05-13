package com.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class UdpServer {

	public static void main(String[] args) throws IOException {

		System.out.println("UdpServer服务启动");
		
		DatagramSocket ds = new DatagramSocket(8080);

		byte[] buf = new byte[1024];

		DatagramPacket dp = new DatagramPacket(buf, buf.length);

		ds.receive(dp);//接受消息，线程阻塞，到接受到消息继续运行

		String add = dp.getAddress().toString();

		int port = dp.getPort();
		
		SocketAddress socketAddress = dp.getSocketAddress();

		String data = new String(dp.getData(), 0, dp.getLength());
		
		ds.close();

		//此处socketAddress接收到的port不为8080，这是在client中没有调用bind绑定地址，而且，在server程序与client程序在同一主机下运行时，
		//绑定同一端口可能会报错。如果在两个不同的机子上分别运行server与client，且分别都绑定了8080端口号，即可得到想要的结果。
		System.out.println("UdpServer接受到UdpClient的消息为：" + socketAddress.toString() + "=====>>" + data);
	}
}
