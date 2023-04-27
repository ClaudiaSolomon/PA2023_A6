create table `java`.`albums`
(
id INT auto_increment,
release_year INT,
name VARCHAR(256),
artist VARCHAR(256),
genre VARCHAR(256),
PRIMARY KEY(id)
);

create table `java`.`artists`
(
id INT auto_increment,
name VARCHAR(256),
PRIMARY KEY(id));

create table `java`.`genres`
(
id INT auto_increment,
name VARCHAR(256),
PRIMARY KEY(id));

create table `java`.`junction`
(
id_album int,
id_genre int,
PRIMARY KEY(id_album),
foreign key(id_album) references albums(id),
foreign key(id_genre) references genres(id));