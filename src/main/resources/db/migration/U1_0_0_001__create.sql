drop table books2authors;

drop table books;

drop table authors;

drop table categories;

delete from flyway_schema_history where version = '1.0.0.001';
