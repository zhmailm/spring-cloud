package com.zhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
	@Autowired
	Environment environment;

	@RequestMapping("/testPath")
	public String testPath() {
		String path = environment.getProperty("server.context-path");
		String port = environment.getProperty("server.port");
		String name = environment.getProperty("name");
		return "本服务名称为:" + path + "   端口号为：" + port+"    name:"+name;
	}
}
