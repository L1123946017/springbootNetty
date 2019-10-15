package com.ljh.server;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/24 21:18
 */
@Component
public class ChildChannelHandler extends ChannelInboundHandlerAdapter {
	public ChildChannelHandler() {
		super();
	}


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println(msg);
		ctx.channel().writeAndFlush("收到客户端发送的请求");
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().writeAndFlush("收到客户端发送的请求");
	}

}
