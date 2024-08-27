create table if not exists files
(
    id serial primary key,
    file_data text not null,
    title text not null,
    creation_date timestamp not null,
    description text not null
);
