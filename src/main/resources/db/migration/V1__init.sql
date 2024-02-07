CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    PRIMARY KEY (id)
);

CREATE TABLE scene (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    budget DECIMAL(10, 2),
    minutes INT,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE character (
    id SERIAL PRIMARY KEY,
    description VARCHAR(100),
    cost DECIMAL(10, 2),
    stock INT,
    scene_id INT,
    FOREIGN KEY (scene_id) REFERENCES scene(id)
);