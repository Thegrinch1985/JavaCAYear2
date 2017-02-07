drop table booking;
drop table ticket;
drop table passengers;
drop table planeroute;
drop table route;
drop table plane;

 
--To drop the sequence so it doesbnt keep adding on the id once created
DROP SEQUENCE pid_seq;

create table plane(
plane_id                varchar2(40),
plane_operator          varchar2(40),
capacity                number,
noStaff                 number,
Primary Key(plane_id)
);

create table route(
route_id                varchar2(40),
route_name              varchar2(40),
duration                number(11),
Primary Key(route_id)
);

create table planeroute(
plane_id                varchar2(40),
route_id                varchar2(40),
Primary Key(plane_id, route_id),
Foreign Key(plane_id) references plane on delete cascade,
Foreign Key(route_id) references route on delete cascade
);

create table passengers(
pass_id                 number,
pass_name               varchar2(80),
pass_dob                date,
Primary Key(Pass_id)
);

create table ticket(
ticket_id               varchar2(40),
ticket_type             varchar2(40),
ticket_cost             number(11),
route_id                varchar2(40),
Primary Key(ticket_id),
Foreign Key(route_id) references route(route_id) on delete cascade
);

create table Booking(
pass_id                 number,
ticket_id               varchar2(40),
Primary Key(pass_id,ticket_id),
Foreign Key(pass_id) references passengers(pass_id) on delete cascade,
Foreign Key(ticket_id) references ticket(ticket_id) on delete cascade
);

CREATE SEQUENCE pid_seq START WITH 1 INCREMENT BY 1 MINVALUE 0;
-- to create the sequence again starting at 1
