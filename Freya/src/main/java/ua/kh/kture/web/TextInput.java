package ua.kh.kture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kh.kture.service.AnswerService;
import ua.kh.kture.service.MainAnswerService;

/**
 * Servlet implementation class IndexServlet
 */
public class TextInput extends HttpServlet {
	private static final long serialVersionUID = 11111111L;
	AnswerService as = new MainAnswerService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("id");
		response.getWriter().write(as.getQuestion(req));
		request.getSession().setAttribute("answer", "theme");
		request.getSession().setAttribute("theme", req);
	}
}
