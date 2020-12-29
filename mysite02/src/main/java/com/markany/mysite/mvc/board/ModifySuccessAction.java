package com.markany.mysite.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.mysite.repository.BoardRepository;
import com.markany.mysite.vo.BoardVo;
import com.markany.web.mvc.Action;
import com.markany.web.util.WebUtil;

public class ModifySuccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setNo(Long.parseLong(no));
		boardVo.setTitle(title);
		boardVo.setContents(contents);
		
		new BoardRepository().update(boardVo);
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=");
	}

}
