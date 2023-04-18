package co.shareit.phonebook.entity;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Contact {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String avatar;
	private String address;
	private String country;
	private Integer userId;
	private Date createdAt = new Date();
}
