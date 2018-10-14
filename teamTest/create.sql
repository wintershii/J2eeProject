create table t_good (
  id int not null auto_increment,
  name varchar(20) not null,
  gType varchar(10) not null,
  location varchar(30) not null,
  gDate date not null,
  gRest int not null,
  primary key (id)
);