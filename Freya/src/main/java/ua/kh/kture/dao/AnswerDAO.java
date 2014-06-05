package ua.kh.kture.dao;

public class AnswerDAO {

	public String getQuestion(String string) {
		switch (string) {
		case "name":
			return "Что расскажешь?";
		default:
			return "Что скажешь по этому поводу?";
		}
	}

	public String getAnswer(String theme, String answer, String text) {
		if (answer != null) {
			if (answer.equals("theme")) {
				switch (theme) {
				case "religion":
					return "На первом свидании не принято говорить о религии;)";
				case "weather":
					return "Погода, все же, замечательная!";
				case "politics":
					return "А у нас в мире компьютеров нет политики!";
				default:
					return "Расскажи еще, я мало об этом слышала!";
				}
			} else {
				return "Мы с тобой всегда говорим о таких интересных вещах!";
			}
		}
		return findTheme(text);
	}

	private String findTheme(String text) {
		if (text.contains(" чем")) {
			return "Выбирай сам.";
		}
		if (text.contains(" как") || text.contains("Как ")) {
			return "Все отлично!";
		}
		if (text.contains(" что") || text.contains("Что ")) {
			return "Сегодня, наконец, высплюсь!";
		}
		if (text.contains(" когда") || text.contains("Когда ")) {
			return "Завтра все будет!";
		}
		if (text.contains(" зачем") || text.contains("Зачем ")) {
			return "Я не виновата!";
		}
		if (text.contains("ривет") || text.contains("дравст")) {
			return "И тебе не хворать, смертный.";
		}
		if (text.contains("асскаж") || text.contains("чего-нибудь")
				|| text.contains("говор")) {
			return "Я могу разговаривать с тобой вечность. Или пока батарея не сядет.";
		} else {
			return "Не понимаю о чем ты...";
		}
	}
}