package com.ljh.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 11:31
 */
@Component
public class NettyServer {

	@Value("${netty.host}")
	private String host;

	@Value("${netty.port}")
	private Integer port;


	@Autowired
	private ChildChannelInitializerServer childChannelInitializer;

	public void run() {
		NioEventLoopGroup boos = null;
		NioEventLoopGroup worker = null;

		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();

			boos = new NioEventLoopGroup();
			worker = new NioEventLoopGroup();
			serverBootstrap
					.group(boos, worker)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024)
					.option(ChannelOption.SO_KEEPALIVE, true)
					.childHandler(childChannelInitializer)
					.bind(this.host, this.port);
		} finally {
			/*worker.shutdownGracefully();
			boos.shutdownGracefully();*/
		}
	}
}
