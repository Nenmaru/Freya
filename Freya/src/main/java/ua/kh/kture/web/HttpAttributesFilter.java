package ua.kh.kture.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class HtttpAtributesFilter. Represents filter
 * set character encoding and cashing
 */
public class HttpAttributesFilter implements Filter {
	Logger log = Logger.getLogger(HttpAttributesFilter.class);

	public void init(FilterConfig fConfig) throws ServletException {
		log.debug("init start");
		log.debug("init end");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.debug("doFilter start");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("UTF-8");
		log.info("encoding for request was set : " + req.getCharacterEncoding());

		resp.addHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		log.info("chache off : "
				+ ((HttpServletResponse) response).getHeader("Cache-Control"));
		resp.setCharacterEncoding("UTF-8");
		log.info("encoding for response was set : "
				+ resp.getCharacterEncoding());

		chain.doFilter(request, response);

		log.debug("doFilter end");
	}

	public void destroy() {
		log.debug("destroy start");

		log.debug("destroy end");
	}

}
