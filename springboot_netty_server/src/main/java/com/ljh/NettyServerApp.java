package com.ljh;

import com.ljh.server.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author Jiahui Li
 * @DATE 2019/9/21 17:05
 */
@SpringBootApplication
public class NettyServerApp implements CommandLineRunner {
	@Autowired
	private NettyServer server;

	public static void main(String[] args) {
		SpringApplication.run(NettyServerApp.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		server.run();
	}
}
