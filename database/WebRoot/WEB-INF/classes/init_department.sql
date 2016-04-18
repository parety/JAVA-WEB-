create table tb_department 
( id int auto_increment, 
  name varchar(255), 
  primary key (id)
);

create table tb_employee 
( id int auto_increment, 
  department_id int,
  name varchar(255), 
  sex varchar(255), 
  employed_date date, 
  primary key (id)
);









