SELECT FROM pg_tables WHERE tablename = 'users';
create table users (id serial primary key, name character varying (100), login character varying (100), email character varying (100), createdDate TIMESTAMP);
