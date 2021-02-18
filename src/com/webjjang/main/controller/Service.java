package com.webjjang.main.controller;

public interface Service {

	// 실행할 method 선언 - 구현하지 않는다.(추상 method)
	public Object service(Object obj) throws Exception;
	
	// dao넣어주는 setter 선언
	public void setDAO(Object dao) throws Exception;
	
}
