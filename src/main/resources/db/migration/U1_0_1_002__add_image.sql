alter table books drop column image;
alter table books drop column year;

delete from flyway_schema_history where version = '1.0.1.002';
