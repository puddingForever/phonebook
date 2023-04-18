package co.shareit.phonebook.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import co.shareit.phonebook.dao.ContactDao;
import co.shareit.phonebook.dao.DaoFactory;
import co.shareit.phonebook.entity.Contact;

public class ContactService {

	public Contact addNewContact(Contact c, Map<String, String> errors) throws IOException {
		
		String name = c.getName().trim();
		if(name.length()==0) {
			errors.put("name", "이름을 입력해주세요");
		}
		else if(name.length()<3) {
			errors.put("name", "최소 세글자를 입력하세요");
		}
		if(c.getEmail().trim().length()==0) {
			errors.put("email", "이메일을 입력해주세요");
		}
		if(c.getPhone().trim().length()==0) {
			errors.put("phone", "핸드폰 번호를 입력해주세요");
		}
		
		if(errors.size()>0) {
			return c;
		}
		
		ContactDao dao = DaoFactory.getContactDao();
		Contact c1 = dao.getContactByEmail(c.getEmail());
		if(c1!=null) {
			errors.put("email", "중복된 이메일입니다.");
		}
		
		c1 = dao.getContactByPhone(c.getPhone());
		
		if(c1!=null) {
			errors.put("phone", "중복된 번호입니다.");
		}
		if(errors.size()>0) {
			return c;
		}
		
		dao.createContact(c);
		
		return c;
	}
	
	public void updateContact(Integer id,Contact c,Map<String,String> errors) throws IOException {
		c.setId(id);
		

		String name = c.getName().trim();
		if(name.length()==0) {
			errors.put("name", "이름을 입력해주세요");
		}
		else if(name.length()<3) {
			errors.put("name", "최소 세글자를 입력하세요");
		}
		if(c.getEmail().trim().length()==0) {
			errors.put("email", "이메일을 입력해주세요");
		}
		if(c.getPhone().trim().length()==0) {
			errors.put("phone", "핸드폰 번호를 입력해주세요");
		}
		
		if(errors.size()>0) {
			return;
		}
		
		ContactDao dao = DaoFactory.getContactDao();
		dao.updateContact(c);
	}

	public Contact getContactById(Integer id,Integer userId) throws IOException {
		return DaoFactory.getContactDao().getContact(id,userId);

	}
	
	public List<Contact> getAllContacts(Integer userId) throws IOException{
		return DaoFactory.getContactDao().getAllContacts(userId);
	}
	
	//로그인한 사람만 접근 가능 , 로그인한 사람은 자기 계정만 삭제 가능  
	public void deleteContactById(Integer id,Integer userId,Map<String,String> errors) throws IOException {
		ContactDao dao = DaoFactory.getContactDao();
		Contact c1 = dao.getContact(id, userId);
		
		if(c1==null) {
			errors.put("userId","삭제가 불가합니다");
			return;
		}
		dao.deleteContact(id);
	}
	
}
