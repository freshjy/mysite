package com.markany.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markany.mysite.mvc.board.BoardActionFactory;
import com.markany.web.mvc.Action;
import com.markany.web.mvc.ActionFactory;


public class BorardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("a");	
		
		ActionFactory actionFactory = new BoardActionFactory();
		Action action = actionFactory.getAction(actionName);
		action.execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 

}
