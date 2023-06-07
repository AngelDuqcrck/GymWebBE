CREATE TABLE IF NOT EXISTS rol (
id INT NOT NULL AUTO_INCREMENT,
descripcion VARCHAR(20) NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY (descripcion)
);

INSERT IGNORE INTO rol (id,descripcion) VALUES
(1,"ADMIN"),
(2,"ENTRENADOR"),
(3,"CLIENTE");

CREATE TABLE IF NOT EXISTS plan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    precio DOUBLE NOT NULL
);

INSERT IGNORE INTO plan (id, nombre, descripcion, precio) VALUES
    (1, 'Fit & Strong', 'Está diseñado para aquellos que desean mejorar su fuerza y resistencia física. Incluye un programa de entrenamiento completo que combina ejercicios cardiovasculares, levantamiento de pesas y entrenamiento de resistencia. Este plan también ofrece acceso a clases grupales de alta intensidad, como spinning y entrenamiento funcional. Además, se brinda asesoramiento nutricional personalizado para ayudar a los participantes a alcanzar sus objetivos de forma saludable.', 60000),
    (2, 'Total Body Transformation', 'Está diseñado para aquellos que desean transformar completamente su cuerpo. Incluye un programa integral que combina entrenamiento de fuerza, ejercicios de alta intensidad, sesiones de cardio y clases de yoga para mejorar la flexibilidad y el equilibrio. Además, se brinda asesoramiento nutricional individualizado para optimizar los resultados. Este plan también ofrece seguimiento regular del progreso y apoyo constante por parte de entrenadores especializados.', 100000),
    (3, 'Mind & Body Wellness', 'Se centra en el bienestar holístico, combinando entrenamiento físico con prácticas de relajación y equilibrio mental. Incluye acceso a clases de yoga, pilates y meditación, que ayudan a mejorar la flexibilidad, la fuerza muscular y la tranquilidad mental. Este plan también ofrece sesiones individuales de terapia de masajes y asesoramiento de bienestar para fomentar el autocuidado y la salud emocional.', 80000);

