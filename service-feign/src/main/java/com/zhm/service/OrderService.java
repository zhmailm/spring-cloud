package com.zhm.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//定义好注解,去调用的其他接口
@FeignClient(name = "order-server",fallback=OrderServiceFallback.class)
public interface OrderService {
	@RequestMapping("/order/testPath")
	public String testPath();
}
