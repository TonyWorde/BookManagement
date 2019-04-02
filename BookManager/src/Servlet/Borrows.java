package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BorrowService;
import Service.Impl.BorrowServiceImpl;
import Values.TB_Borrow;

@WebServlet("/borrows.view")
public class Borrows extends HttpServlet {

	public Borrows() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		BorrowService bs = new BorrowServiceImpl();
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		list = bs.getBorrowAll();
		if(list==null){
			response.sendRedirect("BorrowEmptyAdmin.jsp");
		}else{
			session.setAttribute("borrowall", list);
			response.sendRedirect("BorrowAllAdmin.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void init() throws ServletException {
	}

}
