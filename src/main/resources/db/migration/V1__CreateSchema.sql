create table product
(
    id          int auto_increment primary key,
    name        varchar(200) not null,
    content varchar(1500) not null
);

create table review
(
    id          int auto_increment primary key,
    content     varchar(5000),
    product_id  int                                 not null,
    reviewed_on  timestamp default CURRENT_TIMESTAMP
);

create table comment
(
    id           int auto_increment primary key,
    content varchar(5000)                      ,
    review_id    int                                 not null,
    commented_on  timestamp default CURRENT_TIMESTAMP
);