package tw.leonchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.leonchen.model.House;
import tw.leonchen.model.HouseService;

@WebServlet("/DemoHouseServletEx1.do")
public class DemoHouseServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WebApplicationContext context;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HouseService houseService = context.getBean("houseService", HouseService.class);
		
		try {
			House houseBean = houseService.select(1001);
			
			if(houseBean!=null) {
				out.write(houseBean.getHouseid() + ":" + houseBean.getHousename() + "<br/>");
			}else {
				out.write("no result<br/>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//((ConfigurableApplicationContext)context).close();
		out.close();
	}

}