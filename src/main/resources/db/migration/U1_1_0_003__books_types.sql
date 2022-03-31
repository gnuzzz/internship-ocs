alter table books drop column science_field, drop column genre, drop column type;

delete from flyway_schema_history where version = '1.1.0.003';
