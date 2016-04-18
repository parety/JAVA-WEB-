create table tb_currency 
( id int auto_increment, 
  account varchar(255) unique, 
  currency double, 
  last_modified timestamp, 
  primary key (id)
);

insert into tb_currency ( account, currency, last_modified ) values ( 'A', 1000, current_timestamp);
insert into tb_currency ( account, currency, last_modified ) values ( 'B', 0, current_timestamp);

