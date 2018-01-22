package com.javaex.Contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.Dao.guestbookDao;
import com.javaex.Vo.guestbookVo;

@WebServlet("/cl")
public class Contoller extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("aname");
		
		if("list".equals(actionName)) {
			System.out.println("list 진입");
			guestbookDao dao =new guestbookDao();
			
			List<guestbookVo> list =dao.getList();
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		}else if("add".equals(actionName)) {
			System.out.println("add 진입");
			
			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String content = request.getParameter("content");
			
			guestbookVo vo = new guestbookVo();
		    guestbookDao dao = new guestbookDao();
		    vo.setName(name);
		    vo.setPassword(password);
		    vo.setContent(content);
			dao.insert(vo);
			
			response.sendRedirect("cl?aname=list");
			
		}else if("deleteform".equals(actionName)) {
			
			String no = request.getParameter("no");
			request.setAttribute("no", no);
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
			
		}else if("delete".equals(actionName)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			guestbookVo vo = new guestbookVo();
		    guestbookDao dao = new guestbookDao();
		    
		    
		    
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
