package com.ljh.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 11:32
 */
@Component
public class NettyClient {

	@Value("${netty.host}")
	private String host;

	@Value("${netty.port}")
	private Integer port;

	@Autowired
	private ChildChannelInitializerClient childChannelInitializerClient;


	public void runCient() throws InterruptedException {
		NioEventLoopGroup group = null;
		try {
			Bootstrap bootstrap = new Bootstrap();
			group = new NioEventLoopGroup();

			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.handler(childChannelInitializerClient);
			sendSms(bootstrap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (group != null) {
				group.shutdownGracefully();
			}

		}


	}


	private void sendSms(Bootstrap bootstrap) throws Exception {
		Channel channel = bootstrap.connect(this.host, this.port).channel();
		while (true) {
			channel.writeAndFlush(new Date() + ": hello world!");
			Thread.sleep(2000);
		}
	}

}
