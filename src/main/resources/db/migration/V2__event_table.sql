create table event (
  id  serial not null,
  place varchar(255),
  text varchar(255),
  time timestamp,
  application_user_id int4,
  primary key (id))