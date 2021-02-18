<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 //------------ 데이터 처리 ------------
 // 요청한 url  가져오기
 // String url = request.getRequestURL().toString();
 String url = request.getServletPath();	// 서버쪽에서의 경로
 
 // 생성되어 있는 서비스를 URL에 맞는 것을 찾아서 실행할 수 있도록 전달한다 = 생성하지 않는다.(이미 생성되어 있기 떄문에)
 int result = (int)ExeService.execute(Beans.get(url), null);

 // 자동으로 list로 이동 시긴다.
 response.sendRedirect("list.jsp");
%>
