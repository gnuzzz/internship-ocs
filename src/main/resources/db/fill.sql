insert into categories(name) values ('Фантастика');
insert into categories(name) values ('Научно-популярная литература');

insert into authors(name) values ('Айзек Азимов');
insert into authors(name) values ('Френк Герберт');
insert into authors(name) values ('Андрей Лазарчук');
insert into authors(name) values ('Михаил Успенский');
insert into authors(name) values ('Дэвид Дойч');

insert into books(title, category_id) select 'Основание', c.id from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Основание' and a.name = 'Айзек Азимов';

insert into books(title, category_id) select 'Дюна', c.id from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Дюна' and a.name = 'Френк Герберт';

insert into books(title, category_id) select 'Посмотри в глаза чудовищ', c.id from categories c where name = 'Фантастика';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Посмотри в глаза чудовищ' and a.name = 'Андрей Лазарчук';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Посмотри в глаза чудовищ' and a.name = 'Михаил Успенский';

insert into books(title, category_id) select 'Структура реальности', c.id from categories c where name = 'Научно-популярная литература';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Структура реальности' and a.name = 'Дэвид Дойч';

insert into books(title, category_id) select 'Взрывающиеся солнца. Тайны сверхновых', c.id from categories c where name = 'Научно-популярная литература';
insert into books2authors(book_id, author_id) select b.id, a.id from books b, authors a where b.title = 'Взрывающиеся солнца. Тайны сверхновых' and a.name = 'Айзек Азимов';
