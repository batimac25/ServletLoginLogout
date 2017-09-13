package com.login.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		if (pass.equals("admin123")) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			req.getRequestDispatcher("profileservlet").include(req, resp);
		} else {
			out.print("UserName or Password Error!!!");
			req.getRequestDispatcher("login.html").include(req, resp);
			;
		}
	}
}
