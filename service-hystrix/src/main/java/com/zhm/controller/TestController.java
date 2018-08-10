package com.zhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	@Autowired
	Environment environment;
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/testPath")
	public String testPath() {
		String path = environment.getProperty("server.context-path");
		String port = environment.getProperty("server.port");
		return "本服务名称为:" + path + "   端口号为：" + port;
	}

	@RequestMapping("/testUrl")
	@HystrixCommand(fallbackMethod = "errorMsg")// 设置出错时，返回的方法
	public String testUrl() {
		return restTemplate.getForObject("http://order-server/member/testPath/", String.class);
	}

	public String errorMsg() {
		return "402:errorMsg";
	}
}
