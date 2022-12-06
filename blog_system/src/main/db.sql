create database if not exists my_blog;
use my_blog;

drop table if exists blog;
create table blog (
    blogId int primary key auto_increment,
    title varchar(1024),
    content mediumtext,
    userId int,
    postTime datetime
);

insert into blog values(null,'这是第一篇博客','从今天开始我要认真学xic++',1,now());
insert into blog values(null,'这是第二篇博客','从昨天开始我要认真学xic++',1,now());
insert into blog values(null,'这是第三篇博客','从前天开始我要认真学xic++',1,now());
insert into blog values(null,'这是第一篇博客','从今天开始我要认真学xijava',2,now());



drop table if exists user;
create table user(
    userId int primary key auto_increment,
    userName varchar(128) unique,
    password varchar(128)
);

insert into user values(null,"zhangsan",123);
insert into user values(null,"lisi",123);

