drop database if exists UserDB;
Create database UserDB;
use UserDB;
/*create table slider*/
create table slider(
slider_id int(10) PRIMARY KEY AUTO_INCREMENT,
name varchar(50),
content text,
imgUrl varchar(50)
);

/*create table user*/
create table `user`(
user_id int(10) PRIMARY KEY AUTO_INCREMENT,
full_name varchar(50),
email varchar(50),
mobile varchar(11),
password varchar(255),
status varchar(50)
);

/*create table role*/
create table role(
role_id int(10) PRIMARY KEY AUTO_INCREMENT,
name varchar(50),
description varchar(50)
);

/*create table user_role*/
create table user_role(
user_id int(10) NOT NULL,
role_id int(10) NOT NULL,
status varchar(50),
created_at datetime default now(),
updated_at datetime,
PRIMARY KEY(user_id, role_id)
);

/*create table menu */
create table menu(
menu_id int(10) AUTO_INCREMENT PRIMARY KEY,
name varchar(50),
description varchar(50),
controller varchar(50),
action varchar(50)
);

/*create table role_menu*/
create table role_menu(
role_id int(10) AUTO_INCREMENT,
menu_id int(10),
status varchar(50),
primary key(role_id,menu_id)
);

/*create table news*/
create table news(
news_id int(10) AUTO_INCREMENT PRIMARY KEY,
url varchar(100),
title text,
description varchar(50),
content text,
status varchar(50),
is_hot bit default 0,
user_id int(10),
approver_id int(10) null,
created_at datetime default now(),
updated_at datetime,
approved_at datetime
);
-- create relationship between tables.
alter table user_role add constraint FK_userID_user foreign key(user_id) references user(user_id);
alter table user_role add constraint FK_roleID_userRole foreign key(role_id) references role(role_id);
alter table role_menu add constraint FK_roleID_roleMenu foreign key(role_id) references `role`(role_id);
alter table role_menu add constraint FK_menuID foreign key(menu_id) references menu(menu_id);
alter table news add constraint FK_userID_news foreign key(user_id) references user(user_id);
alter table news add constraint FK_approverID foreign key(approver_id) references user(user_id);

-- insert data table user.
insert into user(full_name,email,mobile,password,status) values ("Nguyen Thi My Duyen","ntmduyen@cmc.com.vn","0906523717","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Pham Thi Phuong","ptphuong@cmc.com.vn","0902428283","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Vu Van Dong","vvdong@cmc.com.vn","0900723777","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Nguyen Duc Van","ndvan@cmc.com.vn","0955556517","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Giam Doc Hai","gdhai@cmc.com.vn","0906523888","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Nguyen Hung","nhung@cmc.com.vn","095553717","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("Vuong Sy Son","vsson@cmc.com.vn","0886523337","e10adc3949ba59abbe56e057f20f883e",NULL);
insert into user(full_name,email,mobile,password,status) values ("12345","12345","21215","$2a$10$z6Apz0lhaqG.HN8FMq3XQehjLYRKA/CrAvdTkR.FeqsT5es/RMmqW",NULL);

-- insert data table role.
insert into role(name,description) values ("Admin",NULL);
insert into role(name,description) values ("Normal User",NULL);
insert into role(name,description) values ("VIP User",NULL);
insert into role(name,description) values ("Guest",NULL);

-- create table log.
create table log(
id int(10) primary key auto_increment,
logType varchar(50),
content text,
create_at datetime default now()
);

-- insert data table news
INSERT INTO `userdb`.`news` ( `url`, `title`, `description`, `content`, `status`, `is_hot`, `user_id`) VALUES ( '/tin-tuc-1', 'Sau Jennie, tới lượt Rosé được stylist nhà YG thiên vị về trang phục?', 'testing', 'Trong buổi họp báo mới đây, Rosé (Black Pink) là người diện đồ khác biệt nhất làm dấy lên tin đồn YG đang ngầm đẩy cho cô nàng trước khi chính thức solo.', 'chua phe duyet', b'1', b'1');


INSERT INTO `userdb`.`news` ( `url`, `title`, `description`, `content`, `status`, `is_hot`, `user_id`) VALUES ( '/tin-tuc-2', 'Sau Jennie, tới lượt Rosé được stylist nhà YG thiên vị về trang phục?', 'testing', 'Trong buổi họp báo mới đây, Rosé (Black Pink) là người diện đồ khác biệt nhất làm dấy lên tin đồn YG đang ngầm đẩy cho cô nàng trước khi chính thức solo.', 'chua phe duyet', b'1', b'1');

INSERT INTO `userdb`.`news` ( `url`, `title`, `description`, `content`, `status`, `is_hot`, `user_id`) VALUES ( '/tin-tuc-3', 'Sau Jennie, tới lượt Rosé được stylist nhà YG thiên vị về trang phục?', 'testing', 'Trong buổi họp báo mới đây, Rosé (Black Pink) là người diện đồ khác biệt nhất làm dấy lên tin đồn YG đang ngầm đẩy cho cô nàng trước khi chính thức solo.', 'chua phe duyet', b'1', b'1');

INSERT INTO `userdb`.`news` ( `url`, `title`, `description`, `content`, `status`, `is_hot`, `user_id`) VALUES ( '/tin-tuc-4', 'Sau Jennie, tới lượt Rosé được stylist nhà YG thiên vị về trang phục?', 'testing', 'Trong buổi họp báo mới đây, Rosé (Black Pink) là người diện đồ khác biệt nhất làm dấy lên tin đồn YG đang ngầm đẩy cho cô nàng trước khi chính thức solo.', 'chua phe duyet', b'1', b'1');


INSERT INTO `userdb`.`news` ( `url`, `title`, `description`, `content`, `status`, `is_hot`, `user_id`) VALUES ( '/tin-tuc-5', 'Sau Jennie, tới lượt Rosé được stylist nhà YG thiên vị về trang phục?', 'testing', 'Trong buổi họp báo mới đây, Rosé (Black Pink) là người diện đồ khác biệt nhất làm dấy lên tin đồn YG đang ngầm đẩy cho cô nàng trước khi chính thức solo.', 'chua phe duyet', b'1', b'1');