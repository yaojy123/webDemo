package com.yao.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cookies是数组，如果数组中有符合条件Cookie就跳转页面
//		for (Cookie cook : request.getCookies()) {
//			if ("xy".equals(cook.getName()) && "1234".equals(cook.getValue())) {
//				response.sendRedirect("img.jsp");
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理编码问题
		request.setCharacterEncoding("utf-8");
		// 设置服务端的编码格式
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		//String sessionId = session.getId();
		session.setAttribute("userName", "xy");
		//response.getWriter().append(sessionId);
		
		// 从请求中获取userName、passWord
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		if ("xy".equals(userName) && "1234".equals(passWord)) {
			// 判断cookie为空，向客户端添加cookie
			if (request.getCookies() == null) {
				Cookie cookie = new Cookie("xy", "1234");
				response.addCookie(cookie);
			}
			// 重定向（可以在不同项目，会改变地址）
			//response.sendRedirect("firstPage.jsp");
			response.getWriter().append("{\"status\":0,\"msg\":\"登陆成功!\"}");
		} else {
			// 页面输出“登陆失败”
			//response.getWriter().append("登陆失败"+sessionId);
			response.getWriter().append("{\"status\":1,\"msg\":\"登陆失败!\"}");
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
