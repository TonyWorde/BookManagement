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

import Dao.BookDao;
import Dao.Impl.BookDaoImpl;
import Values.TB_Book;

@WebServlet("/bookquery.view")
public class BookQuery extends HttpServlet {
	public BookQuery() {
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
			session.setAttribute("books", list);
			response.sendRedirect("Books.jsp");
		}else response.sendRedirect("BooksFail.jsp");

	}

	public void init() throws ServletException {
		
	}

}
