CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) not null,
    email VARCHAR(50) not null,
    password VARCHAR(255) not null
);