package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.controller.Service;

public class BoardViewService implements Service {

	// DB처리를 위한 DAO선언
	private BoardDAO dao;	// 기본값 = null 이 된다.
	
	@Override
	// DAO를 넣어주는 setter : 밖에서 생성을 해서 넣어준다.
	public void setDAO(Object dao) throws Exception {
		
		this.dao = (BoardDAO)dao;
		
	}
	
	
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("BoardViewService.service() : 게시판 글 보기 처리");
		
		return dao.view();
		
	}

}
