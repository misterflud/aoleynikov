create table rightsRole (
	id serial primary key,
	name character varying(200) not null);

create table roles (
	id serial primary key,
	name character varying(200) not null,
	attribute int
	);

create table rights_for_roles (
	id_right int references rightsrole(id) not null,
	id_role int references roles(id) not null);


create table conditionsOfApplication (
	id serial primary key,
	condition int not null
	);

create table commentsOfApplication (
	id serial primary key,
	comment character varying(300) not null
	);

create table categoriesOfApplication (
	id serial primary key,
	category int not null
	);

create table applications (
	id serial primary key,
	condition_id int references conditionsofapplication(id) not null,
	comment_id int references conditionsofapplication(id) not null,
	category_id int references categoriesofapplication(id) not null
	);

create table usres (
	id serial primary key,
	name character varying(200) not null, 
	login character varying(100) not null,
	password character varying(100) not null,
	role_id int references roles(id) not null,
	application_id int references applications(id) not null
	);

insert into rightsrole (name) values('role1');
insert into rightsrole (name) values('role2');
insert into rightsrole (name) values('role3');

select * from rightsrole;

insert into roles(name, attribute) values('put', 1);
insert into roles(name, attribute) values('get', 2);
insert into roles(name, attribute) values('del', 3);
select * from roles;

insert into rights_for_roles(id_right, id_role) values(1, 1);
insert into rights_for_roles(id_right, id_role) values(2, 1);
insert into rights_for_roles(id_right, id_role) values(2, 2);
insert into rights_for_roles(id_right, id_role) values(2, 3);
insert into rights_for_roles(id_right, id_role) values(3, 3);
select * from rights_for_roles;