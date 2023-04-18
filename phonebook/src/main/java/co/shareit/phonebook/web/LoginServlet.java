package co.shareit.phonebook.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shareit.phonebook.entity.User;
import co.shareit.phonebook.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		 User user = (User)req.getSession().getAttribute("user");
		 if(user!=null) {
			 //로그인한 유저 
			 resp.sendRedirect("./dashboard");
			 return;
		 }
		 
		 //로그인 안한 유저 
		 req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		req.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserService service = new UserService();
		Map<String,String> errors = new HashMap<String,String>();
		User user= service.login(email,password,errors);
		
		if(errors.size()>0) {
			req.setAttribute("errors", errors);
			 req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}	
		else {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("./dashboard");
			 
		}
		
	}
}
