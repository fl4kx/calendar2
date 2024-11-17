USE calendar2;

CREATE TABLE user
(
    id bigint not null auto_increment,
    username varchar(20) unique,
    password varchar(20),
    email varchar(320),
    created_date DATETIME,
    modified_date DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE schedule
(
    id bigint not null auto_increment primary key,
    user_id bigint NOT NULL,
    title varchar(50),
    contents varchar(200),
    registration_date DATETIME,
    modified_date DATETIME,
    foreign key (user_id) references user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
