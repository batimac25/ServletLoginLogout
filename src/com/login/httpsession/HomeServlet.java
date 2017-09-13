package com.login.httpsession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if (session != null) {
			req.getRequestDispatcher("homewithoutlogin.html").include(req, resp);
		} else {
			req.getRequestDispatcher("index.html").include(req, resp);

		}
	}
}
