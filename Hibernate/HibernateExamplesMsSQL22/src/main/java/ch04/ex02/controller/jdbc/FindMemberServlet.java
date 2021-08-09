package ch04.ex02.controller.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch04._00.service.MemberService;
import ch04._00.service.impl.MemberServiceImpl_Jdbc;
import ch04.ex01.model.Member;

/*  
 * 本程式經由Hibernate來存取資料庫
 */
@WebServlet("/ch04/ex02/FindMemberServletJDBC")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		MemberService ms = new MemberServiceImpl_Jdbc(); 
		// 可以是Session的get()或load()方法
		Member member = ms.loadMember(ipk);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex02/updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}
