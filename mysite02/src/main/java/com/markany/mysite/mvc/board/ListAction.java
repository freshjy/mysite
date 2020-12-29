package com.markany.mysite.mvc.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.mysite.repository.BoardRepository;
import com.markany.mysite.vo.BoardVo;
import com.markany.web.mvc.Action;
import com.markany.web.util.WebUtil;


public class ListAction implements Action {
	List<BoardVo> list = new ArrayList<>();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> list = new BoardRepository().findAll();
		request.setAttribute("list", list);
		//System.out.println(list);
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}
}
 