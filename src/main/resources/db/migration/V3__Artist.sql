CREATE TABLE artists (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_deezer BIGINT UNIQUE,
    name VARCHAR(255) UNIQUE NOT NULL,
    image VARCHAR(255),
    nb_album INT
);