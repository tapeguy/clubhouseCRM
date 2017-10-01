/* create service tables */

create table credential (
	id int not null auto_increment primary key,
	user_name varchar(256),
	password varchar(256)
);

create table account (
	id int not null auto_increment primary key,
	member_id int,
	balance double(20), --accept rounding error for now. TODO discuss strategy w/ team
	annual_club_dues double(20)
);

create table payment_plan (
	id int not null auto_increment primary key,
	display varchar(256),
	billing_cycle_in_weeks int,
	fee double(20)
);

create table event (
	id int not null auto_increment primary key,
	event_date_time timestamp,
	display varchar(256),
	leader_id int,
	event_location varchar(256),
	max_event_seats int,
	reserved_event_seats int
);

/* create club role tables */

create table member (
	id int not null auto_increment primary key,
	email varchar(256),
	credential_id int,
	account_id int,
	payment_plan_id varchar(256)
);

create table leader_type (
	id int not null auto_increment primary key,
	display varchar(256),
);

create table leader (
	id int not null auto_increment primary key,
	leader_type_id int,
	credential_id int,
	email varchar(256)
);

/* create club group tables */

create table family (
	id int not null auto_increment primary key,
	family_name varchar(256)
);

create table team (
	id int not null auto_increment primary key,
	team_name varchar(256),
	leader_id int
);

/* create club relationship tables */ 

create table member_family_rel (
	id int not null auto_increment primary key,
	member_id int,
	family_id int
);

create table member_team_rel (
	id int not null auto_increment primary key,
	member_id int,
	team_id int
);
