package com.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		try {
			System.out.println("TCP服务端启动啦");

			// 也是会阻塞在这里。
			Socket accept = serverSocket.accept();

			InputStream inputStream = accept.getInputStream();

			byte[] bytes = new byte[1024];

			int length = inputStream.read(bytes);

			String result = new String(bytes, 0, length);

			System.out.println("服务端接收到客户端发送的消息============>>>" + result);

			OutputStream outputStream = accept.getOutputStream();

			PrintWriter printWriter = new PrintWriter(outputStream);

			printWriter.print("我是服务器，我收到你的消息了，这是服务器自动反馈。");

			printWriter.flush();

			accept.shutdownOutput();
		} catch (Exception e) {

		} finally {
			serverSocket.close();
		}

	}
}
