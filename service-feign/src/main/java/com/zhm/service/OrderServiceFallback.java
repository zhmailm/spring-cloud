package com.zhm.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService {

	@Override
	public String testPath() {
		// TODO Auto-generated method stub
		return "401 errorMsg";
	}

}
