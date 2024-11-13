create database HotelBooking;
use HotelBooking;

create table Room(
room_id int auto_increment primary key,
room_type varchar(50) not null,
price decimal(10,2),
availability boolean default true);

create table Customer(
customer_id int auto_increment primary key,
name varchar(50) not null,
contact varchar(20) not null unique);

create table Booking(
booking_id int auto_increment primary key,
room_id int not null,
customer_id int not null,
booking_date date not null,
duration int not null,
foreign key(room_id) references Room(room_id) on delete cascade,
foreign key(customer_id) references Customer(customer_id) on delete cascade
);

create table Payment(
payment_id int auto_increment primary key,
booking_id int not null,
amount decimal(10,2) not null,
payment_date date not null,
foreign key(booking_id) references Booking(booking_id) on delete cascade
);

create table StandardRoom(
room_id int primary key,
bed_count int default 1,
foreign key(room_id) references Room(room_id) on delete cascade);


create table SuiteRoom(
room_id int primary key,
living_area boolean default true,
foreign key(room_id) references Room(room_id) on delete cascade);

