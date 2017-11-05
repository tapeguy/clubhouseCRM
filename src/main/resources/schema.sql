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
	reserved_seats int
);

create table payment_transaction (
	id int not null auto_increment primary key,
	payment_transaction_date_time timestamp,
	display varchar(256),
	member_id int,
	payment_amount double(20), --accept rounding error for now. TODO discuss strategy w/ team
	payment_type varchar(256)
);

/* create club role tables */

create table member (
	id int not null auto_increment primary key,
	member_type varchar(32),
	name varchar(256),
	email varchar(256),
	family_id int,
	credential_id int,
	account_id int,
	payment_plan_id int
);

create table leader (
	id int not null primary key,
	admin boolean
);

create table president (
    id int not null primary key
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

create table member_team_rel (
	id int not null auto_increment primary key,
	member_id int,
	team_id int
);

create table member_event_rel (
	id int not null auto_increment primary key,
	member_id int,
	event_id int
);

alter table account add constraint account_member_fk foreign key ( member_id ) REFERENCES member ( id ) ;

alter table event add constraint event_leader_fk foreign key ( leader_id ) REFERENCES leader ( id ) ;

alter table payment_transaction add constraint payment_transaction_member_fk foreign key ( member_id ) REFERENCES member ( id ) ;

alter table member add constraint member_family_fk foreign key ( family_id ) REFERENCES family ( id ) ;
alter table member add constraint member_credential_fk foreign key ( credential_id ) REFERENCES credential ( id ) ;
alter table member add constraint member_account_fk foreign key ( account_id ) REFERENCES account ( id ) ;

alter table leader add constraint leader_member_fk foreign key ( id ) REFERENCES member ( id ) ;

alter table president add constraint president_leader_fk foreign key ( id ) REFERENCES leader ( id ) ;

alter table team add constraint team_leader_fk foreign key ( leader_id ) REFERENCES leader ( id ) ;

alter table member_team_rel add constraint member_team_rel_member_fk foreign key ( member_id ) REFERENCES member ( id ) ;
alter table member_team_rel add constraint member_team_rel_team_fk foreign key ( team_id ) REFERENCES team ( id ) ;

alter table member_event_rel add constraint member_event_rel_member_fk foreign key ( member_id ) REFERENCES member ( id ) ;
alter table member_event_rel add constraint member_event_rel_event_fk foreign key ( event_id ) REFERENCES event ( id ) ;