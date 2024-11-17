USE calendar2;

CREATE TABLE user
(
    id bigint not null auto_increment,
    username varchar(20) unique,
    password varchar(20),
    email varchar(320),
    created_date DATE,
    modified_date DATE,
    PRIMARY KEY (id)
);

CREATE TABLE schedule
(
    id bigint not null auto_increment primary key,
    user_id bigint NOT NULL,
    title varchar(50),
    contents varchar(200),
    registration_date DATE,
    modified_date DATE,
    foreign key (user_id) references user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
