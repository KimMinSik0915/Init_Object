<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 //------------ 데이터 처리 ------------
 // 요청한 url  가져오기
 // String url = request.getRequestURL().toString();
 String url = request.getServletPath();	// 서버쪽에서의 경로
 
 // 생성되어 있는 서비스를 URL에 맞는 것을 찾아서 실행할 수 있도록 전달한다 = 생성하지 않는다.(이미 생성되어 있기 떄문에)
 List list = (List)ExeService.execute(Beans.get(url), null);
 
 
 %>
 <!-- 데이터 표시  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
                                                  
<h1>게시판 리스트</h1>
요청 URL(request.getServletPath) : <%= url %><br> 

<a href="writeForm.jsp">글쓰기</a>

</body>
</html>