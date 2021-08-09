
import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.PrintWriter;
//import java.io.IOException;
import mvcdemo.bean.*;
import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
//import javax.rmi.*;
import javax.naming.*;
import javax.sql.*;
import javax.websocket.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Member/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	@Resource(name = "jdbc/iiihealth")
	private DataSource dataSource;

	private HealthDAO healthDAO;

	public void init() throws ServletException {
		healthDAO = new HealthDAO(dataSource);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		// To prevent caching
		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		try {

			if (request.getParameter("insertHealth") != null)
				insertHealth(request, response);
			
			else if (request.getParameter("insertToSQL") != null)
				insertToSQL(request, response);

			else if (request.getParameter("searchAllHealth") != null)
				searchAllHealth(request, response);
			
			else if (request.getParameter("totalToInsert") != null)
				totalToInsert(request, response);

			else if (request.getParameter("totalToSearchOne") != null)
				totalToSearchOne(request, response);
			
			else if (request.getParameter("totalToDeleteOne") != null)
				totalToDeleteOne(request, response);

			else if (request.getParameter("totalToUpdateOne") != null)
				totalToUpdateOne(request, response);
			
			else if (request.getParameter("gotoTotal") != null)
				gotoTotal(request, response);

			else if (request.getParameter("searchHealth") != null)
				searchHealth(request, response);
			
			else if (request.getParameter("deleteHealth") != null)
				deleteHealth(request, response);

			else if (request.getParameter("updateHealth") != null)
				updateHealth(request, response);
			
			else if (request.getParameter("displayUpdateHealth") != null)
				displayUpdateHealth(request, response);

			else if (request.getParameter("sublogin") != null)
				login(request, response);
			
			else if (request.getParameter("searchAllToUpdate") != null)
				searchAllToUpdate(request, response);
						
			else if (request.getParameter("updateSearchHealth") != null)
				updateSearchHealth(request, response);
			
			else if (request.getParameter("displayUpdateSearchHealth") != null)
				displayUpdateSearchHealth(request, response);
			
			else if (request.getParameter("") != null)
				displayUpdateSearchHealth(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 新增資料
	public void insertHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ename;
		String gender;
		String rocid1;
		String year1, month1, day1;
		String cname1;
		String account1;
		String pwd1;
		String pwd2;
		String email1;
		String phone1;
		String phone2;
		String addr1;
		String addr2;
		String addr3;

		int intEmpno = (int) Math.floor(Math.random() * 100000000);
		String empno = String.valueOf(intEmpno);

		ename = request.getParameter("ename").trim();
		gender = request.getParameter("gender").trim();
		rocid1 = request.getParameter("rocid1").trim();
		year1 = request.getParameter("year1").trim();
		month1 = request.getParameter("month1").trim();
		day1 = request.getParameter("day1").trim();
		cname1 = request.getParameter("cname1").trim();
		account1 = request.getParameter("account1").trim();
		pwd1 = request.getParameter("pwd1").trim();
		pwd2 = request.getParameter("pwd2").trim();
		email1 = request.getParameter("email1").trim();
		phone1 = request.getParameter("phone1").trim();
		phone2 = request.getParameter("phone2").trim();
		addr1 = request.getParameter("addr1").trim();
		addr2 = request.getParameter("addr2").trim();
		addr3 = request.getParameter("addr3").trim();

		HealthBean insertHealth = new HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1,
				pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3);
		request.getSession(true).setAttribute("insertHealth", insertHealth);

		HealthBean test = (HealthBean) request.getSession(true).getAttribute("insertHealth");

		request.getRequestDispatcher("DisplayHealth.jsp").forward(request, response);

	}

	// 查詢所有
	public void searchAllHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

//		String deleteSelect =request.getParameter("ds");  //hidden1
//		ArrayList<HealthBean> arrayHealth = healthDAO.searchAllHealth(deleteSelect);	//hidden2

		ArrayList<HealthBean> arrayHealth = healthDAO.searchAllHealth();

		request.getSession(true).setAttribute("arrayHealth", arrayHealth);
		request.getRequestDispatcher("DisplaySearchAll.jsp").forward(request, response);

	}

	// 單筆查詢
	public void searchHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {


		String empno;


		empno = request.getParameter("empno").trim();
		ArrayList<HealthBean> searchHealthByNo = healthDAO.searchHealthByNo(empno);

//		HealthBean arrayHealth = searchHealthByNo.get(0);
//		System.out.println(arrayHealth);
		request.getSession(true).setAttribute("arrayHealth", searchHealthByNo);
		request.getRequestDispatcher("DisplaySearchAll.jsp").forward(request, response);

	}

	// 刪除
	public void deleteHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		boolean torf = false;
		String empno = request.getParameter("empno").trim();
		torf = healthDAO.deleteHealth(empno);
		System.out.println(torf);
		request.getSession(true).setAttribute("arrayHealth", torf);
		request.getRequestDispatcher("Total.jsp").forward(request, response);

	}

	// 修改
	public void updateHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empno;
		String ename;
		String gender;
		String rocid1;
		String year1, month1, day1;
		String cname1;
		String account1;
		String pwd1;
		String pwd2;
		String email1;
		String phone1;
		String phone2;
		String addr1;
		String addr2;
		String addr3;

		empno = request.getParameter("empno").trim();
		ename = request.getParameter("ename").trim();
		gender = request.getParameter("gender").trim();
		rocid1 = request.getParameter("rocid1").trim();
		year1 = request.getParameter("year1").trim();
		month1 = request.getParameter("month1").trim();
		day1 = request.getParameter("day1").trim();
		cname1 = request.getParameter("cname1").trim();
		account1 = request.getParameter("account1").trim();
		pwd1 = request.getParameter("pwd1").trim();
		pwd2 = request.getParameter("pwd2").trim();
		email1 = request.getParameter("email1").trim();
		phone1 = request.getParameter("phone1").trim();
		phone2 = request.getParameter("phone2").trim();
		addr1 = request.getParameter("addr1").trim();
		addr2 = request.getParameter("addr2").trim();
		addr3 = request.getParameter("addr3").trim();
		HealthBean updateHealth = new HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1,
				pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3);
		request.getSession(true).setAttribute("updateHealth", updateHealth);
		request.getRequestDispatcher("DisplayUpdate.jsp").forward(request, response);

	}

	// 新增單筆進SQL
	public void insertToSQL(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println(request.getSession(true).getAttribute("insertHealth"));

		HealthBean healthData = (HealthBean) request.getSession(true).getAttribute("insertHealth");

		healthDAO.insertHealth(healthData);

//			if (healthDAO.insertHealth(healthData)) {
//				System.out.println("Get some SQL commands done!");
//				request.getSession(true).setAttribute("healthData", healthData);
//				request.getRequestDispatcher("/Thanks.jsp").forward(request,response);
//			}

		request.getRequestDispatcher("Total.jsp").forward(request, response);

	}

	// 修改單筆進SQL
	public void displayUpdateHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println(request.getSession(true).getAttribute("updateHealth"));

		HealthBean healthData = (HealthBean) request.getSession(true).getAttribute("updateHealth");

		healthDAO.updateHealth(healthData);

//			if (healthDAO.insertHealth(healthData)) {
//				System.out.println("Get some SQL commands done!");
//				request.getSession(true).setAttribute("healthData", healthData);
//				request.getRequestDispatcher("/Thanks.jsp").forward(request,response);
//			}

		request.getRequestDispatcher("Total.jsp").forward(request, response);

	}

	// 登陸介面
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String account1;
		String pwd1;

		account1 = request.getParameter("account1").trim();
		pwd1 = request.getParameter("pwd1").trim();
		List<HealthBean> searchHealthByAP = healthDAO.searchHealthByAP();
		
		for (HealthBean list : searchHealthByAP) {
			System.out.println(list.getAccount1());
			System.out.println(list.getPwd1());
			if (account1.equals(list.getAccount1()) && pwd1.equals(list.getPwd1())) {
				request.getSession(true).setAttribute("arrayHealth", searchHealthByAP);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
				return;
			}
		}
		request.getRequestDispatcher("loginFail.jsp").forward(request, response);
	}

	public void searchAllToUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("UpdateSearchHealth.jsp").forward(request, response);
	}
	

	// 確認在查詢所有下修改的內容
	public void updateSearchHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		
		String empno;
		String ename;
		String gender;
		String rocid1;
		String year1, month1, day1;
		String cname1;
		String account1;
		String pwd1;
		String pwd2;
		String email1;
		String phone1;
		String phone2;
		String addr1;
		String addr2;
		String addr3;
		

		empno = request.getParameter("empno");
		ename = request.getParameter("ename").trim();
		gender = request.getParameter("gender").trim();
		rocid1 = request.getParameter("rocid1").trim();
		year1 = request.getParameter("year1").trim();
		month1 = request.getParameter("month1").trim();
		day1 = request.getParameter("day1").trim();
		cname1 = request.getParameter("cname1").trim();
		account1 = request.getParameter("account1").trim();
		pwd1 = request.getParameter("pwd1").trim();
		pwd2 = request.getParameter("pwd2").trim();
		email1 = request.getParameter("email1").trim();
		phone1 = request.getParameter("phone1").trim();
		phone2 = request.getParameter("phone2").trim();
		addr1 = request.getParameter("addr1").trim();
		addr2 = request.getParameter("addr2").trim();
		addr3 = request.getParameter("addr3").trim();
		HealthBean updateSearchHealth = new HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1,
				pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3);
		request.getSession(true).setAttribute("updateSearchHealth", updateSearchHealth);

		request.getRequestDispatcher("DisplayUpdateSearchHealth.jsp").forward(request, response);

	}
	
	// 在查詢所有下修改進SQL
	public void displayUpdateSearchHealth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		System.out.println(request.getSession(true).getAttribute("updateSearchHealth"));

		HealthBean healthData = (HealthBean) request.getSession(true).getAttribute("updateSearchHealth");

		healthDAO.updateHealth(healthData);

		request.getRequestDispatcher("Total.jsp").forward(request, response);

	}


	public void totalToInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("RegisterForm.jsp").forward(request, response);
	}

	public void totalToSearchOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("SearchHealth.jsp").forward(request, response);
	}

	public void totalToDeleteOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("DeleteHealth.jsp").forward(request, response);
	}

	public void totalToUpdateOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("UpdateHealth.jsp").forward(request, response);
	}

	public void gotoTotal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		request.getRequestDispatcher("Total.jsp").forward(request, response);
	}

}