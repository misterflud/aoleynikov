create table contact (
      id serial PRIMARY KEY
    , first_name varchar(60) not null
    , last_name varchar(60) not null
    , birth_date date
   	, unique (first_name, last_name)
);

create table contact_tel_detail (
    id serial primary key
    , contact_id int not null
    , tel_type varchar(20) not null
    , tel_number varchar(20) not null
    , unique (contact_id, tel_type)
    , constraint fk_contact_tel_detail_1 foreign key (contact_id) references contact(id)
);