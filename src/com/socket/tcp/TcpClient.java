package com.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("127.0.0.1", 8080);

		try {

			OutputStream outputStream = socket.getOutputStream();

			String msg = "这是TCP客户端发送给服务端的消息";

			outputStream.write(msg.getBytes());
			System.out.println("客户端发送消息完毕");

			InputStream inputStream = socket.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

			String result = br.readLine();

			System.out.println("服务器返回的结果===============>>>" + result);
		} finally {
			socket.close();
		}

	}
}
