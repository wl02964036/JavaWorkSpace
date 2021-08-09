package ch04.ex04.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch04._00.service.MemberService;
import ch04._00.service.impl.MemberServiceImpl_WithLazyLoadingFilter;
import ch04.ex01.model.Member;

@WebServlet("/ch04/ex04/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession hsession = request.getSession();
		Map<String, String>  errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		System.out.println(modify);
		MemberService ms = new MemberServiceImpl_WithLazyLoadingFilter();
		
		if (modify.equalsIgnoreCase("DELETE")) {
			try {
				ms.deleteMember(ipk);
				hsession.setAttribute("modify", "刪除成功");
			} catch(Exception ex) {
				hsession.setAttribute("error", "刪除時發生異常: " + ex.getMessage());
			}
		} else if (modify.equalsIgnoreCase("UPDATE")) {
			String userId = request.getParameter("userId");
			String password = request.getParameter("pswd");
			String name = request.getParameter("userName");
			String mail = request.getParameter("eMail");
			String tel = request.getParameter("tel");
			String expericnceStr = request.getParameter("experience");
			
			// 2. 進行必要的資料轉換
			int experience = 0;
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數");
			}
			// 3. 檢查使用者輸入資料
			if (userId == null || userId.trim().length() == 0) {
				errorMsg.put("userId", "帳號欄必須輸入");
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("pswd", "密碼欄必須輸入");
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("userName", "姓名欄必須輸入");
			}
			if (mail == null || mail.trim().length() == 0) {
				errorMsg.put("eMail", "EMail欄必須輸入");
			}
			if (tel == null || tel.trim().length() == 0) {
				errorMsg.put("tel", "電話號碼欄必須輸入");
			}
			if (experience < 0) {
				errorMsg.put("experience", "使用Java經驗應該為正整數或 0 ");
			}
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex04/updateMemberHBNFilter.jsp");
				rd.forward(request, response);
				return;
			}
			
			Member m = new Member(userId, password, name, mail, tel, experience);
			m.setPk(ipk);
			try {
				ms.updateMember(m);
				hsession.setAttribute("modify", "修改成功");
			} catch(Exception ex) {
				hsession.setAttribute("error", "修改時發生異常: " + ex.getMessage());
			}
		} 		
		response.sendRedirect(request.getContextPath() + "/ch04/ex04/queryAllMembersHBNFilter.do");
		                                                             
	}
}
