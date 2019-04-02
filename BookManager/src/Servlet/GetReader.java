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

import Service.ReaderService;
import Service.Impl.ReaderServiceImpl;
import Values.TB_Reader;

@WebServlet("/reader.view")
public class GetReader extends HttpServlet {

	public GetReader() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request. setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	
		List<TB_Reader> tr = new ArrayList<TB_Reader>();
		String id = (String) session.getAttribute("ReaderId");
		ReaderService rs = new ReaderServiceImpl();
		tr = rs.getReaderById(id);
		
		session.setAttribute("reader", tr);
		response.sendRedirect("Reader.jsp");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}
	
	public void init() throws ServletException {
	}

}
