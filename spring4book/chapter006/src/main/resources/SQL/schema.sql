create table contact (
      id serial not null
    , first_name varchar(60) not null
    , last_name varchar(60) not null
    , birth_date date
    , unique (uq_contact_1, first_name, last_name)
    , primary key (id)
);

create table contact_tel_detail (
    id serial not null
    , contact_id int not null
    , tel_type varchar(20) not null
    , tel_number varchar(20) not null
    , unique (uq_contact_tel_detail, contact_id, tel_type)
    , primary key (id)
    , constraint fk_contact_tel_detail_1 foreign key (contact_id) references contact(id)
);