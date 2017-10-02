insert into payment_plan (display, billing_cycle_in_weeks, fee) values ('Basic', 4, 19.95), ('Premium', 4, 1001.00);

insert into leader_type (display) values ('President'), ('Team Leader');

insert into credential (user_name, password) values ('admin', 'admin'), ('user', 'user');

insert into leader (name, leader_type_id, credential_id, email) values ('Mr. Smithers', (select id from leader_type where display = 'Team Leader'), (select id from credential where user_name = 'admin'), 'smithers@gmail.com'), ('Mr. Burns', (select id from leader_type where display = 'President'), (select id from credential where user_name = 'admin'),'burns@gmail.com');

insert into member (name, email, credential_id, account_id, payment_plan_id) VALUES ('Maggie Simpson', null, (select id from credential where user_name = 'user'), null, (select id from payment_plan where display = 'Premium')), ('Bart Simpson', 'eat_my_shorts@gmail.com', (select id from credential where user_name = 'admin'), null, (select id from payment_plan where display = 'Basic')), ('Lisa Simpson', 'coltrain@gmail.com', (select id from credential where user_name = 'user'), null, (select id from payment_plan where display = 'Basic')), ('Marge Simpson', 'marge@gmail.com', (select id from credential where user_name = 'user'), null, (select id from payment_plan where display = 'Basic')), ('Homer Simpson', 'duff@gmail.com', (select id from credential where user_name = 'user'), null, (select id from payment_plan where display = 'Basic'));
