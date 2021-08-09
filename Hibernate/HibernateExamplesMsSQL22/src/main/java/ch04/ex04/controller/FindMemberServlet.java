package ch04.ex04.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch04._00.service.MemberService;
import ch04._00.service.impl.MemberServiceImpl_WithLazyLoadingFilter;
import ch04.ex01.model.Member;

@WebServlet("/ch04/ex04/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		MemberService ms = new MemberServiceImpl_WithLazyLoadingFilter();
		Member member = ms.loadMember(ipk);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex04/updateMemberHBNFilter.jsp");
		rd.forward(request, response);
		return;
	}
}