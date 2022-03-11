create schema if not exists wedding_rsvp;
use wedding_rsvp;

create table if not exists event (
    event_id int not null auto_increment primary key,
    location varchar(50) not null,
    eventName varchar(255) not null
);

create table if not exists guest (
    id int not null auto_increment primary key,
    guest_id int not null,
    guestName varchar(50) not null,
    guestEmail varchar(50) not null,
    totalInvited VARCHAR(50) not null,
    attending BOOLEAN not null
);


show tables;


describe event;
describe guest;


select * from event;
select * from guest;



/* Foreign Keys: event*/
alter table guest add constraint fk_guest_event FOREIGN KEY (guest_id) REFERENCES event(event_id);
