insert into payment_plan (display, billing_cycle_in_weeks, fee) values ('Free', 4, 0.0), ('Leader Discount', 4, 10.99), ('Basic', 4, 19.95), ('Premium', 4, 201.00);

insert into credential (user_name, password) values
('president', 'president'),
('leader', 'leader'),
('user1', 'user1'),
('user2', 'user2'),
('user3', 'user3'),
('user4', 'user4'),
('user5', 'user5');

insert into member (name, member_type, email, credential_id, account_id, payment_plan_id) values
('Mr. Burns', 'PRESIDENT', 'burns@gmail.com', (select id from credential where user_name = 'president'), null, (select id from payment_plan where display = 'Free')),
('Mr. Smithers', 'LEADER', 'smithers@gmail.com', (select id from credential where user_name = 'leader'), null, (select id from payment_plan where display = 'Leader Discount')),
('Maggie Simpson', 'MEMBER', null, (select id from credential where user_name = 'user1'), null, (select id from payment_plan where display = 'Premium')),
('Bart Simpson', 'MEMBER', 'eat_my_shorts@gmail.com', (select id from credential where user_name = 'user2'), null, (select id from payment_plan where display = 'Basic')),
('Lisa Simpson', 'MEMBER', 'coltrain@gmail.com', (select id from credential where user_name = 'user3'), null, (select id from payment_plan where display = 'Basic')),
('Marge Simpson', 'MEMBER', 'marge@gmail.com', (select id from credential where user_name = 'user4'), null, (select id from payment_plan where display = 'Basic')),
('Homer Simpson', 'MEMBER', 'duff@gmail.com', (select id from credential where user_name = 'user5'), null, (select id from payment_plan where display = 'Basic'));

insert into leader (id) values ( (select id from member where name = 'Mr. Burns') );
insert into leader (id) values ( (select id from member where name = 'Mr. Smithers') );

insert into president (id) values ( (select id from member where name = 'Mr. Burns') );