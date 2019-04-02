package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Values.TB_Book;

import Dao.BookDao;
import Dao.Impl.BookDaoImpl;

@WebServlet("/query.view")
public class BorrowQuery extends HttpServlet {
	public BorrowQuery() {
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
		
		response.setContentType("text/html");
		request. setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String bookname = request.getParameter("bookname");
		BookDao bd = new BookDaoImpl();
		List<TB_Book> list = new ArrayList<TB_Book>();
		list = bd.queryBookByName(bookname);
		if((!list.isEmpty())&&(list!=null)){
			session.setAttribute("borrowquery", list);
			response.sendRedirect("Borrow.jsp");
		}else response.sendRedirect("BorrowQueryFail.jsp");
	}

	public void init() throws ServletException {
		
	}

}
