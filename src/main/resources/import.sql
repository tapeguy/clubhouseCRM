insert into payment_plan (display, billing_cycle_in_weeks, fee) values
('Free', 4, 0.0),
('Leader Discount', 4, 10.99),
('Basic', 4, 19.95),
('Premium', 4, 201.00);

insert into credential (user_name, password) values
('president', 'president'),
('leader', 'leader'),
('user1', 'user1'),
('user2', 'user2'),
('user3', 'user3'),
('user4', 'user4'),
('user5', 'user5'),
('user6', 'user6');

insert into family (family_name) values ('Simpson');

insert into member (name, member_type, email, family_id, credential_id, account_id, payment_plan_id) values
('Mr. Burns', 'PRESIDENT', 'burns@gmail.com', null, (select id from credential where user_name = 'president'), null, (select id from payment_plan where display = 'Free')),
('Mr. Smithers', 'LEADER', 'smithers@gmail.com', null, (select id from credential where user_name = 'leader'), null, (select id from payment_plan where display = 'Leader Discount')),
('Maggie Simpson', 'MEMBER', null, (select id from family where family_name = 'Simpson'), (select id from credential where user_name = 'user1'), null, (select id from payment_plan where display = 'Premium')),
('Bart Simpson', 'MEMBER', 'eat_my_shorts@gmail.com', (select id from family where family_name = 'Simpson'), (select id from credential where user_name = 'user2'), null, (select id from payment_plan where display = 'Basic')),
('Lisa Simpson', 'MEMBER', 'coltrain@gmail.com', (select id from family where family_name = 'Simpson'), (select id from credential where user_name = 'user3'), null, (select id from payment_plan where display = 'Basic')),
('Marge Simpson', 'MEMBER', 'marge@gmail.com', (select id from family where family_name = 'Simpson'), (select id from credential where user_name = 'user4'), null, (select id from payment_plan where display = 'Basic')),
('Homer Simpson', 'MEMBER', 'duff@gmail.com', (select id from family where family_name = 'Simpson'), (select id from credential where user_name = 'user5'), null, (select id from payment_plan where display = 'Basic')),
('Han Solo', 'LEADER', 'wookie_lover@gmail.com', null, (select id from credential where user_name = 'user6'), null, (select id from payment_plan where display = 'Leader Discount'));

insert into leader (id, admin) values ( (select id from member where name = 'Mr. Burns'), TRUE );
insert into leader (id, admin) values ( (select id from member where name = 'Mr. Smithers'), FALSE );
insert into leader (id, admin) values ( (select id from member where name = 'Han Solo'), TRUE );

insert into president (id) values ( (select id from member where name = 'Mr. Burns') );

insert into team ( team_name, leader_id) values ( 'White Belts', (select id from member where name = 'Mr. Burns') );
insert into team ( team_name, leader_id) values ( 'Civil War Re-enactors', (select id from member where name = 'Mr. Smithers') );
insert into team ( team_name, leader_id) values ( 'Star Wars Fan Club', (select id from member where name = 'Han Solo') );

insert into event ( event_date_time, display, leader_id, event_location, max_event_seats, reserved_seats ) values
(null, 'Xmas Party', (select id from member where name = 'Han Solo' ), 'Power Plant', 500, 371 ),
(null, 'Belt Ceremony', (select id from member where name = 'Mr. Smithers' ), 'Main Street Dojo', 50, 21 ),
(null, 'Beginners Class', null, 'Yoga Studio A', 20, 14 );

insert into account ( member_id, annual_club_dues, balance) values
( (select id from member where name = 'Homer Simpson'), 15.99, 0),
( (select id from member where name = 'Marge Simpson'), 15.99, 0),
( (select id from member where name = 'Mr. Burns'), 19.99, 19.99),
( (select id from member where name = 'Han Solo'), 19.99, 39.98);

insert into payment_transaction (payment_transaction_date_time, display, member_id, payment_amount, payment_type ) values
(null, 'Monthly Membership', 7, 99.99, 'Pay Pal'),
(null, 'Event', 3, 15.00, 'Amex'),
(null, 'Annual Membership', 5, 199.99, 'Discover'),
(null, 'Late Fee', 4, 10.00, 'Pay Pal');