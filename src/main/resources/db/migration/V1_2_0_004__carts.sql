create table users(
  email varchar(1024) not null,
  name varchar(1024) not null,
  constraint users_pk primary key (email)
);

create table carts(
    id varchar(1024) not null,
    constraint carts_pk primary key (id),
    constraint carts_user_email foreign key (id) references users(email)
);

create table cart_items(
    id bigserial not null,
    cart_id varchar(1024) not null,
    book_id bigint not null,
    quantity int null,
    constraint cart_items_pk primary key (id),
    constraint cart_items_cart_id_fk foreign key (cart_id) references carts(id),
    constraint cart_items_book_id_fk foreign key (book_id) references books(id)
);

alter table books add price bigint not null default 0;
alter table books add vat int not null default 0;
