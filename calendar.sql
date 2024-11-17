USE calendar2;

CREATE TABLE user
(
    id bigint not null auto_increment,
    username varchar(20) unique,
    password varchar(20) NOT NULL,
    email varchar(320) NOT NULL ,
    registration_date DATETIME,
    modified_date DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE schedule
(
    id bigint not null auto_increment primary key,
    user_id bigint NOT NULL,
    title varchar(50) NOT NULL,
    contents varchar(200) NOT NULL,
    registration_date DATETIME,
    modified_date DATETIME,
    foreign key (user_id) references user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
