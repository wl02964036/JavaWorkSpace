﻿package ch04.ex04.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch04._00.service.MemberService;
import ch04._00.service.impl.MemberServiceImpl_WithLazyLoadingFilter;
import ch04.ex01.model.Member;

@WebServlet("/ch04/ex04/queryAllMembersHBNFilter.do")

public class QueryAllMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberServiceImpl_WithLazyLoadingFilter();
		Collection<Member> coll = ms.getAllMembers();
		request.setAttribute("AllMembers", coll);
		RequestDispatcher rd = request
				.getRequestDispatcher("/ch04/ex04/showAllMembersHBNFilter.jsp");
		rd.forward(request, response);
		return;
	}
}
