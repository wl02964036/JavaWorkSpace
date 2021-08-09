﻿package ch04.ex01.controller;

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
import ch04._00.service.impl.MemberServiceImpl_Hibernate;
import ch04.ex01.model.Member;

@WebServlet("/ch04/ex01/register0401.do")
public class Register0401_HBN extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMsg);
		// 1. 讀取使用者輸入資料
		String userId = request.getParameter("userId");
		String password = request.getParameter("pswd");
		String name = request.getParameter("userName");
		String eMail = request.getParameter("eMail");
		String tel = request.getParameter("tel");
		String expericnceStr = request.getParameter("experience");
		int experience = 0;
		// 2. 進行必要的資料轉換
		if (expericnceStr == null || expericnceStr.trim().length() == 0) {
			errorMsg.put("experience", "使用Java經驗欄必須輸入-3");
		} else {
			try {
				experience = Integer.parseInt(expericnceStr.trim());
			} catch (NumberFormatException e) {
				errorMsg.put("experience", "使用Java經驗格式錯誤，應該為整數-3");
			}
		}
		// 3. 檢查使用者輸入資料
		if (userId == null || userId.trim().length() == 0) {
			errorMsg.put("userId", "帳號欄必須輸入-3");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("pswd", "密碼欄必須輸入-3");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.put("userName", "姓名欄必須輸入-3");
		}
		if (eMail == null || eMail.trim().length() == 0) {
			errorMsg.put("eMail", "EMail欄必須輸入-3");
		}
		if (tel == null || tel.trim().length() == 0) {
			errorMsg.put("tel", "電話號碼欄必須輸入-3");
		}
		if (experience < 0) {
			errorMsg.put("userId", "使用Java經驗應該為正整數或 0 -3");
		}
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex01/ch0401_InputData_HBN.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		MemberService ms = new MemberServiceImpl_Hibernate(); 
		if (ms.idExists(userId)) {
			errorMsg.put("userId", "該代號 (" + userId + ") 已經存在，請換新的代號");
		} else {
			try {
				Member mem = new Member(userId, password, name, eMail, tel, experience);
				ms.saveMember(mem);
			} catch (Exception e) {
				errorMsg.put("userId", "儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		HttpSession session = request.getSession();
		session.setAttribute("userIdKey", userId);
		if (errorMsg.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/ch04/ex01/Ch0401_Success_HBN.jsp");  
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/ch04/ex01/ch0401_InputData_HBN.jsp");
			rd.forward(request, response);
			return;
		}
	}
}