alter table books add image varchar(1024) null;
alter table books add "year" int null;
update books set "year" = 2022;