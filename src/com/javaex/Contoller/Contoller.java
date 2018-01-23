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
import com.javaex.util.WebUtil;

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
			
			WebUtil.forward(request, response, "/WEB-INF/list.jsp");
			
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			//rd.forward(request, response);
			
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
			
			WebUtil.redirect(request, response, "/guestbook2/cl?aname=list");
			//response.sendRedirect("/guestbook2/cl?aname=list");
			
		}else if("deleteform".equals(actionName)) {
			
			String no = request.getParameter("no");
			request.setAttribute("no", no);
			
			
			WebUtil.forward(request, response, "/WEB-INF/deleteform.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteform.jsp");
			//rd.forward(request, response);
			
		}else if("delete".equals(actionName)) {
			System.out.println("delete 진입");
			
			int no = Integer.parseInt(request.getParameter("no"));
			String pass = request.getParameter("password");
		    guestbookDao dao = new guestbookDao();
		    
		    dao.delete(no, pass);
		    
		    WebUtil.redirect(request, response, "/guestbook2/cl?aname=list");
		    //response.sendRedirect("/guestbook2/cl?aname=list");
		    
		    
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
