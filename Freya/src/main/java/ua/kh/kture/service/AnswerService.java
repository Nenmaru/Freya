package ua.kh.kture.service;

import javax.servlet.http.HttpSession;

public interface AnswerService {
	public String getAnswer(String text, HttpSession session);

	public String getQuestion(String string);
}
