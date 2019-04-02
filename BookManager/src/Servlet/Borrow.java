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

@WebServlet("/borrow.view")
public class Borrow extends HttpServlet {

	public Borrow() {
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
		int stock = 0;
		Boolean result = false;
		
		BookService bs = new BookServiceImpl();
		BorrowService brs = new BorrowServiceImpl();
		stock = bs.getBookStockById(id);
		result = brs.setBorrow(re_id, id, stock);
		
		if(result)
			response.sendRedirect("BorrowSucceed.jsp");
		else response.sendRedirect("BorrowFail.jsp");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	public void init() throws ServletException {

	}

}
