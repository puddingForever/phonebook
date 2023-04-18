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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		

		 User user = (User)req.getSession().getAttribute("user");
		 if(user!=null) {
			 //로그인한 유저면 
			 resp.sendRedirect("./dashboard");
			 return;
		 }
		 
		
		req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		//1.read input from request
		//2.service로 부터 , user 객체를 받거나 , 에러시 null을 받음
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String cPassword = req.getParameter("c_password");
		
		//make use of a model function 
		UserService service = new UserService();
		Map<String, String> errors = new HashMap<String,String>();
		User user = service.registerUser(name, email, password, cPassword, errors);
		
		if(errors.size()>0) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
		}
		else {
			req.getSession().setAttribute("user", user); //sessionscope에 user가 있음 
			resp.sendRedirect("./dashboard");
		}
	}
}
