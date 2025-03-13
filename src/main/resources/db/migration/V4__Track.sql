CREATE TABLE tracks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_deezer INT UNIQUE,
    title VARCHAR(255),
    link VARCHAR(500),
    duration INT,
    `rank` INT,
    id_artist INT,
    FOREIGN KEY (id_artist) REFERENCES artists(id) ON DELETE CASCADE
);