CREATE TABLE artists (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_deezer INT UNIQUE,
    name VARCHAR(255) UNIQUE NOT NULL,
    image VARCHAR(255),
    nb_album INT
);