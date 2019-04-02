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

import Service.BorrowService;
import Service.Impl.BorrowServiceImpl;
import Values.TB_Borrow;

@WebServlet("/borrowall.view")
public class GetBorrow extends HttpServlet {

	public GetBorrow() {
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
		String re_id = (String)session.getAttribute("ReaderId");
		List<TB_Borrow> list = new ArrayList<TB_Borrow>();
		
		BorrowService bs = new BorrowServiceImpl();
		list = bs.getBorrowAll(re_id);
		
		if((list!=null)&&(!list.isEmpty())){
			session.setAttribute("borrow", list);
			response.sendRedirect("BorrowAll.jsp");
		}else response.sendRedirect("BorrowEmpty.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

	public void init() throws ServletException {
	}

}
