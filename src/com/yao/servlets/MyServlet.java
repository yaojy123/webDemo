package com.yao.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
		
	private static final long serialVersionUID = 2331530398236911063L;

	/* 
	 *客户发出请求才开始初始化 
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化...");
	}	
	
	/* 
	 * 执行任务时的主要方法，初始化后，请求先进入service方法，检查是get，还是post并调用相应doget，dopsot方法
	 * service
	 * 
	 */
	
	@Override	
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	/* 
	 * doget有一个public的方法，是genericServlet的方法，用来给servlet回传数据的，
	 *protected void doGet 接受标准的http请求，一般用的是这个
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//向客户端相应文本数据
		//转发 (只能在同项目,不会改变地址)
		req.getRequestDispatcher("img.html").forward(req, resp);
		//重定向（可以在不同项目，会改变地址）
		//resp.sendRedirect("https://www.baidu.com");
		
//		PrintWriter pw = resp.getWriter();
//		pw.write("doGet方法");


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("doPost方法");
	}
	
	/* 
	 * 声明周期结束，只有一次，关闭服务器的时候
	 */
	public void destory() {
		System.out.println("servlet销亡...");

	}

}
