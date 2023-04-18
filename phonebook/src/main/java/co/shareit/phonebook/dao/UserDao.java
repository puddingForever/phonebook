package co.shareit.phonebook.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import co.shareit.phonebook.entity.User;

public interface UserDao {

	//CRUD
	@Insert("insert into users (name,email,password,created_at) values (#{name},#{email},#{password},#{createdAt})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void createUser(User user);
	
	//Queries
	@Select("select * from users where email = #{email}")
	@Results({
		@Result(column = "created_at", property = "createdAt")
	})
	public User getUserByEmail(String email);
}
