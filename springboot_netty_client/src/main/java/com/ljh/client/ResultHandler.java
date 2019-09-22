package com.ljh.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 13:04
 */
@Component
public class ResultHandler extends SimpleChannelInboundHandler<String> {
	//处理远程放回数据


	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
		System.out.println("服务端发送的数据：" + s);
	}
}
