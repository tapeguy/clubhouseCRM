insert into payment_plan (display, billing_cycle_in_weeks, fee) values
('Free', 4, 0.0),
('Leader Discount', 4, 10.99),
('Basic', 4, 19.95),
('Premium', 4, 201.00);

insert into credential (user_name, password) values
('president', '$2a$10$joiHDq3b8.0G6NUck5259eps6LEpsXNK16Rc9pWhwLhtIXxqLfpY.'),
('leader', '$2a$10$ER3XVFJzyQCyTMtc3huE0uH/i0QbGUpD0XKfM9toXc67pqQ/ljjgC'),
('user1', '$2a$10$J98445.hWibWAAKa8lb0S.i2gQqjyCL42CS2qDNevkJNad90CPHH.'),
('user2', '$2a$10$lIL5zNpb3ErvijJTnxTw/eC5FUHxUf15Q58dWkVow0ycVBHqZnQpS'),
('user3', '$2a$10$R1eGZF8YOfg5DB82icMbYea/mn8mt.bjpaRTb2CbiyIH3FjzNxE.q'),
('user4', '$2a$10$qhkjynshXlOUS0/4LBRLze/np8uWBJ3AbQdGql2zPbF/l.Mri/B0y'),
('user5', '$2a$10$TuFfgPSg/pOHl4DOE6D3R.NM34E2kgTuR2LFGRgI1xHIuSeq0AstW'),
('user6', '$2a$10$FVo0Y5Zmkv9JjYwkJ03mG.HZxCxaKLsn13dIqSYgNcpR46huvARgm');

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

insert into team (team_name, leader_id) values ( 'White Belts', (select id from member where name = 'Mr. Burns') );
insert into team (team_name, leader_id) values ( 'Civil War Re-enactors', (select id from member where name = 'Mr. Smithers') );
insert into team (team_name, leader_id) values ( 'Star Wars Fan Club', (select id from member where name = 'Han Solo') );

insert into member_team_rel (member_id, team_id) values
((select id from member where name = 'Maggie Simpson'), (select id from team where team_name = 'White Belts')),
((select id from member where name = 'Lisa Simpson'), (select id from team where team_name = 'White Belts')),
((select id from member where name = 'Mr. Burns'), (select id from team where team_name = 'Star Wars Fan Club')),
((select id from member where name = 'Mr. Burns'), (select id from team where team_name = 'Civil War Re-enactors'));

insert into event ( event_date_time, display, leader_id, event_location, max_event_seats, reserved_seats ) values
('2017-12-23 15:00:00', 'Xmas Party', (select id from member where name = 'Han Solo'), 'Power Plant', 500, 371 ),
('2017-01-21 10:30:00', 'Belt Ceremony', (select id from member where name = 'Mr. Smithers'), 'Main Street Dojo', 50, 21 ),
('2018-01-15 12:00:00', 'Beginners Class', null, 'Yoga Studio A', 20, 14 );

insert into member_event_rel (member_id, event_id) values
((select id from member where name = 'Maggie Simpson'), (select id from event where display = 'Belt Ceremony')),
((select id from member where name = 'Lisa Simpson'), (select id from event where display = 'Belt Ceremony')),
((select id from member where name = 'Bart Simpson'), (select id from event where display = 'Belt Ceremony')),
((select id from member where name = 'Mr. Burns'), (select id from event where display = 'Xmas Party')),
((select id from member where name = 'Mr. Burns'), (select id from event where display = 'Beginners Class'));

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
