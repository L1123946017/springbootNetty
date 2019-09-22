package com.ljh.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 12:44
 */
@Component
public class ChildChannelInitializerClient extends ChannelInitializer<Channel> {


	@Autowired
	private ResultHandler resultHandler;

	@Override
	protected void initChannel(Channel channel) throws Exception {
		channel.pipeline().addLast(new StringEncoder())
				.addLast(resultHandler);
	}
}
