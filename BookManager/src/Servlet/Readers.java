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
import Service.ReaderService;
import Service.Impl.BorrowServiceImpl;
import Service.Impl.ReaderServiceImpl;
import Values.TB_Borrow;
import Values.TB_Reader;

@WebServlet("/readers.view")
public class Readers extends HttpServlet {
	public Readers() {
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
		ReaderService rs = new ReaderServiceImpl();
		List<TB_Reader> list = new ArrayList<TB_Reader>();
		list = rs.getReaderAll();
		session.setAttribute("readers", list);
		response.sendRedirect("ReaderAll.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
