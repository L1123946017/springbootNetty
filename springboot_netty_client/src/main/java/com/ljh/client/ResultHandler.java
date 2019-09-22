package com.ljh.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 13:04
 */
@Component
public class ResultHandler extends ChannelInboundHandlerAdapter {
	//处理远程放回数据


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		//

	}
}
