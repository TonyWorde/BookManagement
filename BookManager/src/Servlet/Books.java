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

import Service.BookService;
import Service.ReaderService;
import Service.Impl.BookServiceImpl;
import Service.Impl.ReaderServiceImpl;
import Values.TB_Book;
import Values.TB_Reader;

@WebServlet("/books.view")
public class Books extends HttpServlet {
	public Books() {
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
		BookService bs = new BookServiceImpl();
		List<TB_Book> list = new ArrayList<TB_Book>();
		list = bs.getBookAll();
		session.setAttribute("bookall", list);
		response.sendRedirect("BookAll.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
		
	}

}
