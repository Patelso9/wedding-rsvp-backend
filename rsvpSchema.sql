create schema if not exists wedding_rsvp;
use wedding_rsvp;
create table if not exists event (
    rsvp_id INT NOT NULL auto_increment primary key,
    guest_id INT NOT NULL,
    guest_name varchar(50) not null,
    guest_email varchar(50) not null,
    total_attending int not null,
    description varchar(50) not null
);
create table if not exists guest (
    id int not null auto_increment primary key,
    guest_name varchar(50) not null,
    guest_email varchar(50) not null,
    attending BOOLEAN not null
);

describe event;
describe guest;

INSERT INTO guest(guest_name,guest_email,attending) VALUE("William Short","william@mail.com",TRUE);
INSERT INTO guest(guest_name,guest_email,attending) VALUE("Richard Lagahid","richard@mail.com",TRUE);
INSERT INTO guest(guest_name,guest_email,attending) VALUE("Jhon Gallera","john@mail.com",TRUE);
INSERT INTO guest(guest_name,guest_email,attending) VALUE("Brian Rey","brian@mail.com",TRUE);
INSERT INTO guest(guest_name,guest_email,attending) VALUE("Mick Miller","mic@mail.com",TRUE);

select * from event;
select * from guest;


/* Foreign Keys:  */
alter table event add constraint fk_event_guest foreign key (rsvp_id) references guest(id);

ALTER TABLE event DROP FOREIGN KEY fk_event_guest;