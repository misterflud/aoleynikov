create table rightsRole (
	id serial primary key,
	name character varying(200) not null);

create table roles (
	id serial primary key,
	name character varying(200) not null,
	attribute int,
	rightsRole_id int references rightsRole(id) not null
	);

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