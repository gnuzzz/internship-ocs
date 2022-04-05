insert into categories(name) values ('Фантастика');
insert into categories(name) values ('Научно-популярная литература');
insert into categories(name) values ('Сатира');

insert into authors(name) values ('Айзек Азимов');
insert into authors(name) values ('Френк Герберт');
insert into authors(name) values ('Андрей Лазарчук');
insert into authors(name) values ('Михаил Успенский');
insert into authors(name) values ('Дэвид Дойч');
insert into authors(name) values ('Илья Ильф');
insert into authors(name) values ('Евгений Петров');

insert into books(title, category_id, image, "year", "type", genre, price, vat) select 'Основание', c.id, 'foundation.png', 1951, 'science-fiction', 'space opera', 110, 10 from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Основание' and a.name = 'Айзек Азимов';

insert into books(title, category_id, image, "year", "type", genre, price, vat) select 'Дюна', c.id, 'dune.png', 1965, 'science-fiction', 'space opera', 100, 10 from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Дюна' and a.name = 'Френк Герберт';

insert into books(title, category_id, image, "year", "type", genre, price, vat) select 'Посмотри в глаза чудовищ', c.id, 'monster-eye.png', 1997, 'science-fiction', 'magic reality', 100, 10 from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Посмотри в глаза чудовищ' and a.name = 'Андрей Лазарчук';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Посмотри в глаза чудовищ' and a.name = 'Михаил Успенский';

insert into books(title, category_id, image, "year", "type", science_field, price, vat) select 'Структура реальности', c.id, 'structure.png', 1997, 'popular-science', 'phisics', 90, 20 from categories c where name = 'Научно-популярная литература';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Структура реальности' and a.name = 'Дэвид Дойч';

insert into books(title, category_id, image, "year", "type", science_field, price, vat) select 'Взрывающиеся солнца. Тайны сверхновых', c.id, 'supernova.png', 1985, 'popular-science', 'astronomy', 80, 20 from categories c where name = 'Научно-популярная литература';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Взрывающиеся солнца. Тайны сверхновых' and a.name = 'Айзек Азимов';

insert into books(title, category_id, image, "year", "type", price, vat) select 'Золотой теленок', c.id, 'golden-calf.png', 1931, 'satire', 50, 30 from categories c where name = 'Сатира';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Золотой теленок' and a.name = 'Илья Ильф';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Золотой теленок' and a.name = 'Евгений Петров';

insert into users(email, name) values ('vpupkin@test.com', 'Василий Пупкин');
insert into carts(id) values ('vpupkin@test.com');
