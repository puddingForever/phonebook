package co.shareit.phonebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.shareit.phonebook.entity.Contact;

public interface ContactDao {

	//CRUD
	@Insert("insert into contacts (name,email,phone,avatar,address,country,user_id,created_at)"
			+ " values (#{name},#{email},#{phone},#{avatar},#{address},#{country},"
			+ "#{userId},#{createdAt})")
	@Options(useGeneratedKeys = true,keyProperty="id")
	void createContact(Contact c);
	
	@Select("select * from contacts where id= #{id} and user_id=#{userId}")
	@Results({
		@Result(column = "user_id", property="userId"),
		@Result(column = "created_at", property="createdAt")
	})
	Contact getContact(@Param("id")Integer id,@Param("userId")Integer userId);
	
	@Update("update contacts set name = #{name},email=#{email},phone=#{phone},avatar=#{avatar}, address=#{address},country=#{country},user_id=#{userId} where id=#{id}")
	void updateContact(Contact c);
	
	@Delete("delete from contacts where id=#{id}")
	void deleteContact(Integer id);
	
	
	//Queries

	@Select("select * from contacts where user_id=#{userId}")
	@Results({
		@Result(column = "user_id", property="userId"),
		@Result(column = "created_at", property="createdAt")
	})
	List<Contact> getAllContacts(Integer userId);

	
	@Select("select * from contacts where email=#{email}")
	@Results({
		@Result(column = "user_id", property="userId"),
		@Result(column = "created_at", property="createdAt")
	})
	Contact getContactByEmail(String email);

	@Select("select * from contacts where phone=#{phone}")
	@Results({
		@Result(column = "user_id", property="userId"),
		@Result(column = "created_at", property="createdAt")
	})
	Contact getContactByPhone(String phone);



	

}
