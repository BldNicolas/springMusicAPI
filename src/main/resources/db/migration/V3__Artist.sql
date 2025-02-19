CREATE TABLE artists (
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL,
    image VARCHAR(255),
    nb_album INT
);