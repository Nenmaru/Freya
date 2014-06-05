package ua.kh.kture.service;

import javax.servlet.http.HttpSession;

import ua.kh.kture.dao.AnswerDAO;

public class MainAnswerService implements AnswerService {
	AnswerDAO answerDAO = new AnswerDAO();

	@Override
	public String getAnswer(String text, HttpSession session) {
		String theme = (String) session.getAttribute("theme");
		String answer = (String) session.getAttribute("answer");
		String answ = answerDAO.getAnswer(theme,answer, text);
		return answ;
	}

	@Override
	public String getQuestion(String string) {
		return answerDAO.getQuestion(string);
	}

}
