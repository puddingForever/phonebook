package co.shareit.phonebook.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shareit.phonebook.entity.Contact;
import co.shareit.phonebook.entity.User;
import co.shareit.phonebook.service.ContactService;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = req.getParameter("id");
		if(input==null) {
			resp.sendRedirect("./");
			return;
		}
		
		Integer id = Integer.parseInt(input);
		User user = (User)req.getSession().getAttribute("user");
		//등록되지 않은 값을 contact에 저장하면 null이 나옴 
		Contact c1 = new ContactService().getContactById(id,user.getId());
		req.setAttribute("contact", c1);
		req.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String confirm = req.getParameter("confirm");
		
		User user = (User)req.getSession().getAttribute("user");
		ContactService service = new ContactService();
		if(confirm.equals("DELETE")==false) {
			Contact c1 = service.getContactById(id,user.getId());
			req.setAttribute("contact", c1);
			req.setAttribute("errMessage", "DELETE를 입력해야 삭제가 진행됩니다.");
			req.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(req, resp);
			
		}
		else {
			Map<String,String> errors = new HashMap<String,String>();
			service.deleteContactById(id, user.getId(), errors);
			if(errors.size()==0) {
				resp.sendRedirect("./");
			}
			else {
				req.setAttribute("errors", errors);
				req.getRequestDispatcher("/WEB-INF/views/confirm-delete-contact.jsp").forward(req, resp);

			}
		}
		
	}
	

}
