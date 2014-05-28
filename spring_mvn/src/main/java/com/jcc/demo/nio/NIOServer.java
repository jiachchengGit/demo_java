package com.jcc.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {

	private Selector selector ;
	
	public void initServer(int port) throws IOException{
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(port));
		selector = Selector.open();
		channel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	public void listen() throws IOException{
		System.out.println("服务器端启动监听............");
		while(true){
			selector .select();
			Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				if(key.isAcceptable()){
					ServerSocketChannel server = (ServerSocketChannel)key.channel();
					SocketChannel accept = server.accept();
					accept.configureBlocking(false);
					accept.write(ByteBuffer.wrap(new String("服务端向客户端发送信息........").getBytes()));
					accept.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					read(key);
				}
			}
		}
	}
	
	/**
	 * @param key
	 * @throws IOException 
	 */
	private void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel)key.channel();
		// 创建读取的缓冲区  
        ByteBuffer buffer = ByteBuffer.allocate(10);  
        channel.read(buffer);  
        byte[] data = buffer.array();  
        String msg = new String(data).trim();  
        System.out.println("服务端收到信息："+msg);  
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());  
        channel.write(outBuffer);// 将消息回送给客户端  
	}

	public static void main(String[] args) throws IOException {
		
		NIOServer server = new NIOServer();  
        server.initServer(8000);  
        server.listen();
        
	}

}
