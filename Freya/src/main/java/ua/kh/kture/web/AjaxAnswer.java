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
public class AjaxAnswer extends HttpServlet {
	private static final long serialVersionUID = 11111111L;
	AnswerService as = new MainAnswerService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		String text = new String(request.getParameter("uno_texto").getBytes(),
				"UTF-8");

		if (request.getSession().getAttribute("reqName") != null) {
			response.getWriter().write("Очень приятно! А я чат-бот Freya.");
			request.getSession().setAttribute("user", text);
			request.getSession().removeAttribute("reqName");
			return;
		}


		response.getWriter().write(as.getAnswer(text, request.getSession()));
		request.getSession().removeAttribute("theme");
		request.getSession().removeAttribute("answer");
	}

}
