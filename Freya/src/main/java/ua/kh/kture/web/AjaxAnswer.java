package ua.kh.kture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kh.kture.service.AnswerService;
import ua.kh.kture.service.AnswerServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
public class AjaxAnswer extends HttpServlet {
	private static final long serialVersionUID = 11111111L;
	AnswerService as = new AnswerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		response.getWriter().write("{text:\"" + text + "\"}");
		response.getWriter().flush();
	}

}
