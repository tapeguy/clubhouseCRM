create table member (
	id int not null auto_increment primary key,
	account_number int,
	name varchar(256),
	membership_plan varchar(256)
);