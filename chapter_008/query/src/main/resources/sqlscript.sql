delete from comments where application_id is null;
alter table comments alter column application_id set not null;
alter table comments add foreign key (application_id) references applications(id);
insert into comments (description, application_id) values ('bl bla3', 1);


create table right_roles (
id serial primary key,
name character varying(150) not null);


create table roles (
id serial primary key,
name character varying(100),
right_id int references right_roles(id) not null);



alter table users add column roles_id int references roles(id);


create table condition_of_application (
id serial primary key,
condition int);


create table files (
id serial primary key,
name character varying(100));


create table categiries_of_applications (
id serial primary key,
categories int);



---------------------------
CREATE TABLE public.applications
(
  id integer NOT NULL DEFAULT nextval('application_id_seq'::regclass),
  description text,
  create_date timestamp without time zone NOT NULL DEFAULT now(),
  CONSTRAINT application_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.applications
  OWNER TO postgres;

