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

public class ReplySuccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		Long userNo = authUser.getNo();
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		String groupNo = request.getParameter("groupNo");
		String orderNo = request.getParameter("orderNo");
		String depth = request.getParameter("depth");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setUserNo(userNo);
		boardVo.setTitle(title);
		boardVo.setContents(contents);
		boardVo.setGroupNo(Long.parseLong(groupNo));
		boardVo.setOrderNo(Integer.parseInt(orderNo));
		boardVo.setDepth(Integer.parseInt(depth));
	
		new BoardRepository().insertReply(boardVo);	
		
		WebUtil.redirect(request, response, request.getContextPath() + "/board?a=");
	}

}
