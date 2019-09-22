package com.ljh;

import com.ljh.client.ChildChannelInitializerClient;
import com.ljh.client.NettyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/22 12:42
 */
@SpringBootApplication
public class NettyClientApp implements CommandLineRunner {


	@Autowired
	private NettyClient nettyClient;

	public static void main(String[] args) {
		SpringApplication.run(NettyClientApp.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		nettyClient.runCient();
	}
}
