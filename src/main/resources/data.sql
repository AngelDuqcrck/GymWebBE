CREATE TABLE IF NOT EXISTS rol (
    id INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (descripcion)
);

INSERT IGNORE INTO rol (id,descripcion) VALUES
    (1,"ROLE_ADMIN"),
    (2,"ROLE_ENTRENADOR"),
    (3,"ROLE_CLIENTE");

CREATE TABLE IF NOT EXISTS plan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    precio DOUBLE NOT NULL
);

INSERT IGNORE INTO plan (id, nombre, descripcion, precio) VALUES
    (1, 'Fit & Strong', 'Está diseñado para aquellos que desean mejorar su fuerza y resistencia física. Incluye un programa de entrenamiento completo que combina ejercicios cardiovasculares, levantamiento de pesas y entrenamiento de resistencia. Este plan también ofrece acceso a clases grupales de alta intensidad, como spinning y entrenamiento funcional. Además, se brinda asesoramiento nutricional personalizado para ayudar a los participantes a alcanzar sus objetivos de forma saludable.', 60000),
    (2, 'Total Body Transformation', 'Está diseñado para aquellos que desean transformar completamente su cuerpo. Incluye un programa integral que combina entrenamiento de fuerza, ejercicios de alta intensidad, sesiones de cardio y clases de yoga para mejorar la flexibilidad y el equilibrio. Además, se brinda asesoramiento nutricional individualizado para optimizar los resultados. Este plan también ofrece seguimiento regular del progreso y apoyo constante por parte de entrenadores especializados.', 100000),
    (3, 'Mind & Body Wellness', 'Se centra en el bienestar holístico, combinando entrenamiento físico con prácticas de relajación y equilibrio mental. Incluye acceso a clases de yoga, pilates y meditación, que ayudan a mejorar la flexibilidad, la fuerza muscular y la tranquilidad mental. Este plan también ofrece sesiones individuales de terapia de masajes y asesoramiento de bienestar para fomentar el autocuidado y la salud emocional.', 80000);

CREATE TABLE IF NOT EXISTS musculo_objetivo (
id INT PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(255) NOT NULL
);

INSERT IGNORE INTO musculo_objetivo (id, descripcion) VALUES
    (1, "Abductores"),
    (2, "Abdominales"),
    (3, "Adductores"),
    (4, "Biceps"),
    (5, "Sistema cardiovascular"),
    (6, "Deltoides"),
    (7, "Antebrazos"),
    (8, "Gluteos"),
    (9, "Isquiotibiales"),
    (10, "Dorsal"),
    (11, "Pectoral"),
    (12, "Triceps"),
    (13, "Espalda alta"),
    (14, "Cuadriceps");


CREATE TABLE IF NOT EXISTS parte_del_cuerpo (
id INT PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(255) NOT NULL
);

INSERT IGNORE INTO parte_del_cuerpo (id, descripcion) VALUES
    (1, "Espalda"),
    (2, "Cardio"),
    (3, "Pecho"),
    (4, "Antebrazos"),
    (5, "Piernas bajas"),
    (6, "Cuello"),
    (7, "Hombros"),
    (8, "Brazos superiores"),
    (9, "Piernas altas"),
    (10, "Cintura");

CREATE TABLE IF NOT EXISTS usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    contrasena VARCHAR(255) NOT NULL, 
    correo VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    rol_id int,
    FOREIGN KEY (rol_id) REFERENCES rol (id)
);

INSERT IGNORE INTO usuario (id, correo, contrasena, nombre, rol_id)  VALUES 
    (1,"admin@admin.com", "$2a$12$4AzuqGNswepxwcpCYyGCqeQFopXvxM8yFgs.QlyPmhOE6yJqhLai.", "administrador", 1)

