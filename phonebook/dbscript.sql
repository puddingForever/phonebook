--runscript from 'C:\myJava\MyServletWorkspace\phonebook\dbscript.sql'
drop table contacts if exists;
drop table users if exists;

create table users(
	id int primary key auto_increment,
	name varchar(50) not null,
	email varchar(255) not null unique,
	password varchar(255) not null,
	created_at dateTime
);


create table contacts(
id int primary key auto_increment,
name varchar(50) not null,
email varchar(255) not null unique,
phone varchar(100) not null unique,
avatar varchar(255),
address varchar(255),
country varchar(50),
user_id int,
created_at dateTime,
constraint fk_users foreign key (user_id) references users(id)
);