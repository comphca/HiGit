drop database if exists hotel;
create database hotel;
use hotel;

create table t_user(
		id int primary key auto_increment,
		loginName varchar(20),
		password varchar(20)
	)engine=innodb default charset=utf8;
	
create table t_room_type(
		id int primary key auto_increment,
		name varchar(20),
		price double
	)engine=innodb default charset=utf8;
	
create table t_room(
		id int primary key auto_increment,
		roomNo varchar(20),
		typeId int,
		foreign key(typeId) references t_room_type(id)
	)engine=innodb default charset=utf8;
	
	
create table t_subscription(
		id int primary key auto_increment,
		userId int,
		status  int,
		foreign key(userId) references t_user(id)
	)engine=innodb default charset=utf8;

create table t_subscription_detail(
		id int primary key auto_increment,
		subId int,
		roomId int,
		roomerName varchar(20),
		IDCard varchar(20),
		foreign key(subId) references t_subscription(id),
		foreign key(roomId) references t_room(id)
	)engine=innodb default charset=utf8;