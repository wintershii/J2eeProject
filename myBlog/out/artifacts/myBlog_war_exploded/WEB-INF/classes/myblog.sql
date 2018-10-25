create table t_user(
  id int not null auto_increment,
  account varchar(20) not null,
  pwd varchar(20) not null,
  name varchar(50) not null,
  sex int not null,
  birth date not null,
  signature varchar(300) not null,
  primary key (id,account)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table t_article(
  id int not null auto_increment,
  title varchar(300) not null,
  author varchar(50) not null,
  aid int not null,
  aDate date not null,
  essay text not null,
  markdown text not null,
  views int not null,
  primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table t_artiDescribe(
  id int not null,
  title varchar(300) not null,
  author varchar(50) not null,
  aid int not null,
  aDate date not null,
  essay text not null,
  views int not null,
  primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_article VALUES (1, '啊啊啊', '我', '1', '2018-08-08', '啊啊啊啊', 0);
