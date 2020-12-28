package com.markany.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.mysite.repository.BoardRepository;
import com.markany.mysite.vo.BoardVo;
import com.markany.web.mvc.Action;
import com.markany.web.util.WebUtil;

public class WriteSuccessAction implements Action {

	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle(title);
		//boardVo.setEmail(email);
		
		//new BoardRepository().insert(boardVo);
		
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}
}
