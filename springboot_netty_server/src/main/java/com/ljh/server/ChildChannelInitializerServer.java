package com.ljh.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 12:14
 */
@Component
public class ChildChannelInitializerServer extends ChannelInitializer<NioSocketChannel> {

	@Autowired
	private ChannelHandler channelHandler;

	@Override
	protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
		nioSocketChannel.pipeline().addLast(new StringDecoder()).addLast(channelHandler);
	}
}
