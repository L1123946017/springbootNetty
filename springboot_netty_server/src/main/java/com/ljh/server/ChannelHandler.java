package com.ljh.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 12:10
 */
@Component
@io.netty.channel.ChannelHandler.Sharable
public class ChannelHandler extends SimpleChannelInboundHandler<String> {


	/**
	 * 读取客户端发送的数据
	 *
	 * @param channelHandlerContext
	 * @param s
	 * @throws Exception
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
		//接受数据的业务逻辑
		System.out.println("客户端发送的数据：" + s);

	}


	/**
	 * 客户端主动链接服务端
	 *
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}


	/**
	 * 客户端主动断开服务端的链接,关闭流
	 *
	 * @param ctx
	 * @throws Exception
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().localAddress().toString() + " 通道不活跃！");
	}

	/**
	 * 发生异常处理
	 *
	 * @param ctx
	 * @param cause
	 * @throws Exception
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		// logger.error("连接异常,连接异常："+ DateUtils.dateToString(new Date())+cause.getMessage(), cause);
		ctx.fireExceptionCaught(cause);

	}
}
