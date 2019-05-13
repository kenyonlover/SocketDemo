package com.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpClient {
	public static void main(String[] args) throws IOException {
		String msg = "UdpClient发送的消息";
		
		//new DatagramSocket()时会自动绑定随机端口；
		//new DatagramSocket(null)时先将port置为空，
		//然后再使用ds.bind(new InetSocketAddress(8888))绑定端口为8888。
		DatagramSocket ds = new DatagramSocket();
		//DatagramSocket ds = new DatagramSocket(null);
		//ds.bind(new InetSocketAddress(8888));
		
		byte[] bytes = msg.getBytes();

		DatagramPacket dp = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("127.0.0.1", 8080));

		ds.send(dp);

		ds.close();

		System.out.println("UdpClient完成发送消息");

	}
}
