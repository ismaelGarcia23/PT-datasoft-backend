
CONNECT datasoft/datasoft@//localhost:1521/FREEPDB1

INSERT INTO generes (name) VALUES ('Ficción');
INSERT INTO generes (name) VALUES ('Ciencia');
INSERT INTO generes (name) VALUES ('Historia');

-- Usuario semilla para satisfacer FK de libros
-- passwd = BCrypt de "Admin123" (puede iniciar sesión con esas credenciales)
INSERT INTO users (full_name, username, passwd, state)
VALUES ('Administrador', 'admin', '$2b$10$8uXXdQhi8Ym1/LevGioIgevxVoL0scuX6FeKgMf.ceRKkxm43oYc2', 'ACT');

INSERT INTO users (full_name, username, passwd, state)
VALUES ('Juan Pérez', 'jperez', '$2b$10$8uXXdQhi8Ym1/LevGioIgevxVoL0scuX6FeKgMf.ceRKkxm43oYc2', 'ACT');

INSERT INTO users (full_name, username, passwd, state)
VALUES ('María García', 'mgarcia', '$2b$10$8uXXdQhi8Ym1/LevGioIgevxVoL0scuX6FeKgMf.ceRKkxm43oYc2', 'ACT');

-- Libros (8 en total, distribuidos entre los 3 géneros)
INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('El señor de los anillos',
        'La épica historia de Frodo y la Comunidad del Anillo en su viaje para destruir el Anillo Único.',
        39.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780618640157-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ficción'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('Harry Potter y la piedra filosofal',
        'Un joven descubre que es un mago y comienza sus estudios en el Colegio Hogwarts.',
        24.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780439708180-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ficción'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('Dune',
        'En el desértico planeta Arrakis, Paul Atreides lucha por sobrevivir y cumplir su destino.',
        34.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780441013593-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ficción'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('Una breve historia del tiempo',
        'Stephen Hawking explica el origen del universo, los agujeros negros y el tiempo de forma accesible.',
        19.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780553380163-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ciencia'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('El gen egoísta',
        'Richard Dawkins propone que la evolución se entiende mejor desde la perspectiva del gen.',
        22.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780198788607-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ciencia'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('Cosmos',
        'Carl Sagan recorre la historia del universo y el lugar de la humanidad en él.',
        27.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780345539434-L.jpg',
        (SELECT id FROM generes WHERE name = 'Ciencia'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('Sapiens: De animales a dioses',
        'Yuval Noah Harari narra la historia de la humanidad desde el Homo Sapiens hasta la actualidad.',
        29.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9780062316097-L.jpg',
        (SELECT id FROM generes WHERE name = 'Historia'),
        (SELECT id FROM users WHERE username = 'admin'));

INSERT INTO books (name, summary, price, state, image, gen_id, usr_id)
VALUES ('El arte de la guerra',
        'Sun Tzu presenta principios de estrategia militar aplicables a cualquier conflicto o negocio.',
        14.99, 'ACT',
        'https://covers.openlibrary.org/b/isbn/9781599869773-L.jpg',
        (SELECT id FROM generes WHERE name = 'Historia'),
        (SELECT id FROM users WHERE username = 'admin'));

COMMIT;
