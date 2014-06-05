package ua.kh.kture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.kh.kture.service.AnswerService;
import ua.kh.kture.service.MainAnswerService;

public class TextLearn extends HttpServlet {
	private static final long serialVersionUID = 11111111L;
	AnswerService as = new MainAnswerService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("id");
		if (request.getSession().getAttribute("user") != null
				&& req.equals("name")) {
			req = "false";
		}
		switch (req) {
		case "name":
			response.getWriter().write("Как тебя зовут?");
			request.getSession().setAttribute("reqName", true);
			break;
		case "false": {
			response.getWriter().write("Я уже знаю, как тебя зовут!");
			request.getSession().removeAttribute("reqName");
			break;
		}
		default:
			response.getWriter().write(as.getQuestion("name"));
			request.getSession().setAttribute("answer", "standart");
			break;
		}
	}
}
