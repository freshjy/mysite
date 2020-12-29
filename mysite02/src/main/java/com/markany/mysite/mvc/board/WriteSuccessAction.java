package com.markany.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.markany.mysite.repository.BoardRepository;
import com.markany.mysite.vo.BoardVo;
import com.markany.mysite.vo.UserVo;
import com.markany.web.mvc.Action;
import com.markany.web.util.WebUtil;

public class WriteSuccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		Long userNo = authUser.getNo();
		
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle(title);
		boardVo.setContents(contents);
		boardVo.setUserNo(userNo);
		
		new BoardRepository().insert(boardVo);		
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=");
	}
}
 