create table categories (
    id bigserial not null,
    name varchar(1024) not null,
    constraint categories_pk primary key (id)
);

create table authors (
    id bigserial not null,
    name varchar(1024) not null,
    constraint authors_pk primary key (id)
);

create table books (
    id bigserial not null,
    title varchar(1024) not null,
    category_id bigint not null,
    constraint books_pk primary key (id),
    constraint books_category_id_fk foreign key (category_id) references categories(id)
);

create table books2authors (
    book_id bigint not null,
    author_id bigint not null,
    constraint books2authors_pk primary key (book_id, author_id),
    constraint books2authors_book_id_fk foreign key (book_id) references books(id),
    constraint books2authors_author_id_fk foreign key (author_id) references authors(id)
);
