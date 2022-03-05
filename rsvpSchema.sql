create schema if not exists wedding_rsvp;
use wedding_rsvp;
create table if not exists event (
    event_id INT NOT NULL auto_increment primary key,
    guestId INT NOT NULL,
    guestName varchar(50) not null,
    guestEmail varchar(50) not null,
    totalAttending int not null,
    description varchar(50) not null
);
create table if not exists guest (
    event_id int not null auto_increment primary key,
    id int NOT NULL,
    name varchar(50) not null,
    email varchar(50) not null,
    attending BOOLEAN not null
);

describe event;
describe guest;

INSERT INTO guest(id,name,email,attending) VALUE(1,"William Short","william@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(2,"Richard Lagahid","richard@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(3,"Jhon Gallera","john@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(4,"Brian Rey","brian@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(5,"Mick Miller","mic@mail.com",TRUE);

INSERT INTO guest(id,name,email,attending) VALUE(6,"Bobby Brown","bobby@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(7,"Ray Charles","rey@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(8,"Steve Vai","Steve@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(9,"Brix Mcnight","brix@mail.com",TRUE);
INSERT INTO guest(id,name,email,attending) VALUE(10,"Tim Allen","tim@mail.com",TRUE);

select * from event;
select * from guest;


/* Foreign Keys:  */
alter table event add constraint fk_event_guest foreign key (event_id) references guest(event_id);

ALTER TABLE event DROP FOREIGN KEY fk_event_guest;