
create table roles(id serial primary key, name character varying (200))
insert into roles(name) values('admin')                   
insert into roles(name) values('user')
--SELECT FROM pg_tables WHERE tablename = 'users';
create table users (id serial primary key, role_id integer references roles(id), name character varying (100), login character varying (100), email character varying (100), password character varying (20),  createdDate TIMESTAMP);



