package com.markany.mysite.mvc.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.mysite.repository.GuestbookRepository;
import com.markany.mysite.vo.GuestbookVo;
import com.markany.web.mvc.Action;
import com.markany.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookRepository repository = new GuestbookRepository();
		List<GuestbookVo> list = repository.findAll();
		
		request.setAttribute("list", list);
		System.out.println(list);
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
	}

}
