package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.*;
import Service.Impl.*;

@WebServlet("/identity.view")
public class Identity extends HttpServlet {
	public Identity() {
		super();
	}
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id =  request.getParameter("username");
		String pwd = request.getParameter("password");
		String person = request.getParameter("person");
		
		
		if(person.equals("admin")){
			AdministerService jugde = new AdministerServiceImpl();
			Boolean result = jugde.judge(id, pwd);
		
			if(result){
				String name = jugde.getAdminNameById(id);
				session.setAttribute("name",name);
				response.sendRedirect("AdministerPage.jsp");
				return;
			}
		}
		
		if(person.equals("reader")){
			ReaderService jugde = new ReaderServiceImpl();
			Boolean result = false;
			result = jugde.judge(id,pwd);
		
			if(result){
				String name = jugde.getReaderNameById(id);
				session.setAttribute("name",name);
				session.setAttribute("ReaderId", id);
				response.sendRedirect("ReaderPage.jsp");
				return;
			}
		}
		
		
		response.sendRedirect("LoginFail.jsp");
	}

	public void init() throws ServletException {
		
	}

}
