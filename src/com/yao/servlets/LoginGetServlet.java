package com.yao.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginGetServlet
 */
@WebServlet("/LoginGetServlet")
public class LoginGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理编码问题
		request.setCharacterEncoding("utf-8");
		// 设置服务端的编码格式
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");

		if ("xy".equals(username) && "1234".equals(password)) {
			response.getWriter().append("{\"status\":0,\"msg\":\"登陆成功!\"}");
		} else {
			response.getWriter().append("{\"status\":1,\"msg\":\"登陆失败!\"}");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
