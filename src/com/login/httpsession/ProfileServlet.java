package com.login.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("name");
			out.println("<body bgcolor='#f2e0a9'>");
			out.print("<h1>Hello " + name + "</h1>");
			out.print("<h2> Welcome to your Profile</h2>");
			req.getRequestDispatcher("profilelink.html").include(req, resp);
		} else {
			out.print("You were not logged in!!!!  Please Login to access the profile!!!!");
			req.getRequestDispatcher("login.html").include(req, resp);
			req.getRequestDispatcher("profilelinkfirst.html").include(req, resp);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}