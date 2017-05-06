create table skill (
    name varchar unique,
    years_of_experience decimal,
    proficiency varchar
);

insert into skill (name, years_of_experience, proficiency) values
    ('bash', 10, 'ADVANCED'),
    ('linux', 10, 'ADVANCED'),
    ('java', 3, 'ADVANCED');
