package co.shareit.phonebook.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/theme")
public class ChangeThemeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String theme = req.getParameter("name");
		List<String> list = Arrays.asList("yeti","superhero");
		if(list.contains(theme)==false) {
			theme = "yeti";
		}
		//쿠키에 theme을 주고 응답해줌
		Cookie c1 = new Cookie("theme",theme);
		c1.setMaxAge(365*24*60*60);
		resp.addCookie(c1);
		resp.sendRedirect("./");
		
	}
	
	

}
