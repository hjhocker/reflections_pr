create table name (
    id bigserial primary key,
    first_name varchar,
    middle_name varchar,
    last_name varchar,

    constraint uc_full_name
      unique (first_name, middle_name, last_name)
);
