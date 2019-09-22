package com.ljh.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 12:10
 */
@Component
public class ChannelHandler extends SimpleChannelInboundHandler<String> {
	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
		//接受数据的业务逻辑
		System.out.println(s);
	}
}
