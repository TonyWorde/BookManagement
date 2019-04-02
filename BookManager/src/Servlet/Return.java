package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.ReturnService;
import Service.Impl.ReturnServiceImpl;

@WebServlet("/return.view")
public class Return extends HttpServlet {

	public Return() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String re_id = (String) session.getAttribute("ReaderId");
		Boolean result = false;
		
		ReturnService rs = new ReturnServiceImpl();
		result = rs.setReturn(re_id, id);
		
		if(result)
			response.sendRedirect("ReturnSucceed.jsp");
		else response.sendRedirect("ReturnFail.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
		
	}

}
