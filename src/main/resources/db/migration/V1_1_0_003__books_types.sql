alter table books add "type" varchar(1024) not null default 'common';
alter table books add genre varchar(1024) null;
alter table books add science_field varchar(1024) null;

update books set "type" = 'science-fiction' where category_id = 1;

update books set "type" = 'popular-science' where category_id = 2;

update books set "type" = 'satire' where category_id = 3;
