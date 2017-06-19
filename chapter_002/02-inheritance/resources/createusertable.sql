SELECT FROM pg_tables  WHERE tablename = 'items'
create table items (id serial primary key, name character varying (100), description character varying (400));
select * from pg_tables where tablename = items;