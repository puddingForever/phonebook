package co.shareit.phonebook.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shareit.phonebook.entity.Contact;

@WebFilter(urlPatterns= {"/add-contact","/edit-and-update-contact"})
public class RequestToContactFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		if(req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String avatar = req.getParameter("avatar");
			String address = req.getParameter("address");
			String country = req.getParameter("country");
			
			Contact c = new Contact();
			c.setName(name);
			c.setEmail(email);
			c.setPhone(phone);
			c.setAvatar(avatar);
			c.setAddress(address);
			c.setCountry(country);
			
			req.setAttribute("contact", c);
			
		}
		
		
	
		
		chain.doFilter(req, resp);
	}

}
