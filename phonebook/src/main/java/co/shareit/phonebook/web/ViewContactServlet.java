package co.shareit.phonebook.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shareit.phonebook.entity.Contact;
import co.shareit.phonebook.entity.User;
import co.shareit.phonebook.service.ContactService;

@WebServlet("/view-contact-details")
public class ViewContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = req.getParameter("id");
		
		if(input==null) {
			resp.sendRedirect("./");
			return;
		}
		
		Integer id = Integer.parseInt(input);
		//Integer id = new Integer(input);
		
		User user = (User) req.getSession().getAttribute("user");
		ContactService service = new ContactService();
		Contact c = service.getContactById(id, user.getId());
		
		req.setAttribute("contact", c);
		req.getRequestDispatcher("/WEB-INF/views/show-contacts.jsp").forward(req, resp);
		
	}
}
