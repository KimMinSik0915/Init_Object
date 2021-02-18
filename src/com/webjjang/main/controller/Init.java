package com.webjjang.main.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;

/**
 * Servlet implementation class Init
 * @인터페이스(초기화 값....), final(초기값 부여 할 수 있다.), 추상메서드 사용 가능
 * @webServlet("/Init") = name에 들어간다.
 * 여러개를 초기화 값으로 입력하려면 항목 이름 = 값 과 ","를 이용하여 구분하여 사용
 */
@WebServlet(value = "/Init", loadOnStartup = 1) // loadOnStratUP = 1 : 서버가 시작하면 첫번째로 시작된다. 숫자가 작아질수록 제일 먼저 실행
public class Init extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 생성자 - 기본생성자
     */
    public Init() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 서버가 실행하면서 호출되는 메서드
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		 System.out.println("Init.init() - 초기화 : 객체 생성");
		 
		 // DAO객체 생성
		 Beans.putDAO("boardDAO", new BoardDAO());
		 
		 // 서비스 객체를 생성해서 저장하는 프로그램
		 Beans.put("/board/list.jsp", new BoardListService());
		 Beans.put("/board/view.jsp", new BoardViewService()); 
		 Beans.put("/board/write.jsp", new BoardWriteService());
		 Beans.put("/board/update.jsp", new BoardUpdateService());
		 Beans.put("/board/delete.jsp", new BoardDeleteService());
		 
		 // DAO객체를 찾아서 Service객체에 넣어준다.
		 try {
			 
			Beans.get("/board/list.jsp").setDAO(Beans.getDAO("boardDAO"));
			Beans.get("/board/view.jsp").setDAO(Beans.getDAO("boardDAO"));
			Beans.get("/board/write.jsp").setDAO(Beans.getDAO("boardDAO"));
			Beans.get("/board/update.jsp").setDAO(Beans.getDAO("boardDAO"));
			Beans.get("/board/delete.jsp").setDAO(Beans.getDAO("boardDAO"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		 
		 System.out.println("객체 생성에 성공하였습니다. ------------------------------------");
		 
	}
 
	
	
}
