create table contact (
      id serial PRIMARY KEY
    , first_name varchar(60) not null
    , last_name varchar(60) not null
    , birth_date date
    , version int not null default 0
   	, unique (first_name, last_name)
);

create table hobby (
    hobby_id varchar(20) not null
    , primary key (hobby_id)
);

create table contact_tel_detail (
    id serial primary key
    , contact_id int not null
    , version int not null
    , tel_type varchar(20) not null
    , tel_number varchar(20) not null
    , unique (contact_id, tel_type)
    , constraint fk_contact_tel_detail_1 foreign key (contact_id) references contact(id)
);

create table contact_hobby_detail (
    contact_id int not null
    , hobby_id varchar(20) not null
    , primary key (contact_id, hobby_id)
    , constraint fk_contact_hobby_detail_1 foreign key(contact_id)
    references contact (id) on delete cascade
    , constraint fk_contact_hobby_detail_2 foreign key (hobby_id)
    references hobby(hobby_id)
);