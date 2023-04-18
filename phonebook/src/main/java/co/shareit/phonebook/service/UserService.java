package co.shareit.phonebook.service;

import java.io.IOException;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import co.shareit.phonebook.dao.DaoFactory;
import co.shareit.phonebook.dao.UserDao;
import co.shareit.phonebook.entity.User;

public class UserService {
	
	public User registerUser(String name,String email,String password, String cPassword,Map<String,String> errors) throws IOException {
		
		
		//체크 
		if(name.trim().length()==0) {
			errors.put("name", "아이디을 입력하세요");
		}else if(name.trim().length()<3) {
			errors.put("name", "아이디는 세글자 이상이여야 합니다.");
		}
		
		if(email.trim().length()==0) {
			errors.put("email", "이메일을 입력하세요");
		}
		if(password.trim().length() == 0) {
			errors.put("password", "비밀번호를 입력하세요");
		}
		if(password.equals(cPassword)==false) {
			errors.put("cPassword", "비밀번호가 동일하지 않습니다.");
		}
		
		UserDao dao = DaoFactory.getUserDao();
		User user = dao.getUserByEmail(email); //db 정보 조회
				
		if(user!=null) {
			errors.put("email", "이미 등록된 이메일입니다");
		}
		//에러가 하나라도 있는 경우 계정 X 
		if(errors.size() > 0) {
			return null;
		}
		
		password = BCrypt.hashpw(password, BCrypt.gensalt(12));
		user = new User(name,email,password);
		dao.createUser(user);
		
		return user;
		
	}

	public User login(String email, String password, Map<String, String> errors) throws IOException {
		if(email.trim().length()==0) {
			errors.put("email", "이메일을 입력해주세요");
		}
		if(password.trim().length()==0) {
			errors.put("password", "비밀번호를 입력해주세요");
		}
		if(errors.size()>0) {
			return null;
		}
	
		UserDao dao = DaoFactory.getUserDao();
		User user = dao.getUserByEmail(email);
		if(user==null) {
			errors.put("email", "가입하지 않은 이메일/비밀번호 입니다.");
		}
		else {
			//사용자가 로그인시 입력한 비번 , hashed된 비번이 같은지 체크 
			boolean result = BCrypt.checkpw(password, user.getPassword());
			if(result==false) {
				errors.put("email", "비밀번호가 틀립니다.");
			}
		}
		if(errors.size()>0) {
			return null;
		}
		return user;
	}

	
}
