package ua.kh.kture.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 11L;
	private String path;

	@Override
	public void init(ServletConfig config) throws ServletException {
		path = config.getServletContext().getInitParameter("ImagePath");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String filepath = path + "\\" + request.getParameter("image");
		System.out.println(filepath);
		BufferedImage image = ImageIO.read(new File(filepath));
		try {
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
