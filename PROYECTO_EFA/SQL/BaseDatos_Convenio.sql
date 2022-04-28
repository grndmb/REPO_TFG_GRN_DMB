-- -----------------------------------
DROP DATABASE BASE_DATOS_CONVENIO;
CREATE DATABASE BASE_DATOS_CONVENIO;
USE BASE_DATOS_CONVENIO;
-- -----------------------------------

-- ------------------------
-- TABLA POBLACION
-- ------------------------
CREATE TABLE POBLACION (
CODIGO_POSTAL INT (5) NOT NULL COMMENT 'Codigo postal',
NOMBRE VARCHAR (50) NOT NULL,
PROVINCIA VARCHAR (50) NOT NULL,
CONSTRAINT PK_POBLACION PRIMARY KEY (CODIGO_POSTAL)
);

-- ----------------------
-- TABLA DATOS EFA
-- ----------------------
CREATE TABLE DATOS_EFA (
NOMBRE VARCHAR (20) NOT NULL,
DIRECCION VARCHAR (100) NOT NULL,
CODIGO_POSTAL INT (5) NOT NULL,
TELEFONO INT NOT NULL,
FAX INT NOT NULL, 
PAGINA_WEB VARCHAR (500) NOT NULL,

CONSTRAINT PK_DATOS_EFA PRIMARY KEY (NOMBRE),
CONSTRAINT FK_DATOS_EFA_POBLACION FOREIGN KEY (CODIGO_POSTAL) REFERENCES POBLACION (CODIGO_POSTAL)
) COMMENT 'Tabla con la informacion de EFA MORATALAZ' ;
-- --------------------------------------------------------


-- ------------------
-- TABLA CURSO
-- ------------------
CREATE TABLE CURSO (
NOMBRE_CURSO VARCHAR (200) NOT NULL COMMENT 'Nombre del curso',
NOMBRE_ABREV VARCHAR (10) NOT NULL COMMENT 'Nombre abreviado del curso',
CLAVE INT NOT NULL COMMENT 'Clave del curso',
HORAS_FCT INT NOT NULL COMMENT 'Horas realizadas en FCT',
ES_PUBLICO BOOLEAN NOT NULL COMMENT 'Enseñanza publica o privada',

CONSTRAINT PK_CURSO PRIMARY KEY (NOMBRE_CURSO)

) COMMENT 'Tabla con la informacion de curso';
-- -------------------------------------------------------------------------------

-- ----------------
-- TABLA ALUMNO
-- ----------------
CREATE TABLE ALUMNO (
NIF VARCHAR (9) NOT NULL COMMENT 'NIF del alumno',
NOMBRE_COMPLETO VARCHAR (60) NOT NULL COMMENT 'Nombre completo del alumno',
SELECCIONADO BOOLEAN NOT NULL COMMENT 'True o False',
TELEFONO INT NOT NULL COMMENT 'Telefono del alumno',
CORREO VARCHAR(100) NOT NULL COMMENT 'Correo del alumno',
FECHA_NACIMIENTO DATE NOT NULL COMMENT 'Fecha de nacimiento del alumno',

NOMBRE_CURSO VARCHAR(200) NOT NULL COMMENT 'Identificador del curso',
CODIGO_POSTAL INT NOT NULL COMMENT 'Codigo postal de la poblacion',

CONSTRAINT PK_ALUMNO PRIMARY KEY (NIF),
CONSTRAINT FK_ALUMNO_CURSO FOREIGN KEY (NOMBRE_CURSO) REFERENCES CURSO (NOMBRE_CURSO),
CONSTRAINT FK_ALUMNO_POBLACION FOREIGN KEY (CODIGO_POSTAL) REFERENCES POBLACION (CODIGO_POSTAL)
) COMMENT 'Tabla con la informacion del alumno';
-- -----------------------------------------------------------------------------------------------------

-- -----------------------
-- TABLA PROFESOR
-- ----------------------

CREATE TABLE PROFESOR (
DNI_PROFESOR VARCHAR (9) NOT NULL COMMENT 'DNI del profesor',
NOMBRE VARCHAR (100) NOT NULL COMMENT 'Nombre del profesor',
CONSTRAINT PK_PROFESOR PRIMARY KEY (DNI_PROFESOR)
);

-- ---------------------
-- TABLA PRACTICA
-- ---------------------
CREATE TABLE PRACTICA (
ID_PRACTICA INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la practica',
TIPO_PRACTICA VARCHAR(3) NOT NULL COMMENT 'Tipo de practica --> (PFE - FCT)',
FECHA_INICIO DATE NOT NULL COMMENT 'Fecha inicial de la practica',
FECHA_FIN DATE NOT NULL COMMENT 'Fecha final de la practica',
FECHA_ANEXO DATE NOT NULL COMMENT 'Fecha firma anexo',
EN_PROCESO BOOLEAN NOT NULL COMMENT 'Indica si la practica esta en proceso',

NOMBRE_CURSO VARCHAR (200) NOT NULL COMMENT 'Nombre del curso asignado a las practicas',
DNI_PROFESOR VARCHAR (9) NOT NULL COMMENT 'DNI del profesor responsable de las practicas',

CONSTRAINT PK_PRACTICA PRIMARY KEY (ID_PRACTICA),
CONSTRAINT FK_PRACTICA_CURSO FOREIGN KEY (NOMBRE_CURSO) REFERENCES CURSO (NOMBRE_CURSO),
CONSTRAINT FK_PRACTICA_PROFESOR FOREIGN KEY (DNI_PROFESOR) REFERENCES PROFESOR (DNI_PROFESOR)
) COMMENT 'Tabla con la infomarcion de las practicas';
-- -----------------------------------------------------------------------------------------------------


-- --------------------------
-- TABLA EMPRESA
-- --------------------------
CREATE TABLE EMPRESA (
CIF_EMPRESA VARCHAR (10) NOT NULL COMMENT 'CIF de la empresa',
NOMBRE_EMPRESA VARCHAR (100) NOT NULL COMMENT 'Nombre de la empresa',
DIRECCION_EMPRESA VARCHAR (200) NOT NULL COMMENT 'Direccion de la empresa',
TELEFONO_1 INT NOT NULL COMMENT 'Telefono 1 de la empresa',
TELEFONO_2 INT NOT NULL COMMENT 'Telefono 2 de la empresa',
EMAIL_EMPRESA VARCHAR (100) NOT NULL COMMENT 'Correo de la empresa',
FAX_EMPRESA VARCHAR (100) NOT NULL COMMENT 'Fax de la empresa',
PAGINA_WEB VARCHAR (1000) NOT NULL COMMENT 'Pagina web de la empresa',

NOMBRE_GERENTE VARCHAR(100) NOT NULL COMMENT 'Nombre del gerente de la empresa',
DNI_GERENTE VARCHAR (9) NOT NULL COMMENT 'DNI del gerente de la empresa',
PERSONA_CONTACTO VARCHAR (100) NOT NULL COMMENT 'Persona de contacto de la empresa',
CARGO_CONTACTO VARCHAR (100) NOT NULL COMMENT 'Cargo del contacto de la empresa',

FECHA_ACTUALIZACION DATE NOT NULL COMMENT 'Fecha de actualizacion de los datos de la empresa',
ORGANISMO_PUBLICO BOOLEAN NOT NULL COMMENT 'Organismo publico o privado',
OBSERVACIONES VARCHAR (500) NOT NULL COMMENT 'Observaciones',

ID_PRACTICA INT NOT NULL COMMENT 'Identificador de la empresa',
CODIGO_POSTAL INT NOT NULL COMMENT 'Codigo postal de la poblacion',

CONSTRAINT PK_EMPRESA PRIMARY KEY (CIF_EMPRESA),
CONSTRAINT FK_EMPRESA_POBLACION FOREIGN KEY (CODIGO_POSTAL) REFERENCES POBLACION (CODIGO_POSTAL)
) COMMENT 'Tabla con la informacion de la empresa';
-- -----------------------------------------------------------------------------------------------------

-- ------------------------
-- TABLA CONVENIO
-- ------------------------
CREATE TABLE CONVENIO (
ID_CONVENIO VARCHAR (20) NOT NULL COMMENT 'Identificador del convenio',
CIF_EMPRESA VARCHAR (10) NOT NULL COMMENT 'Identificador de la empresa',

CONSTRAINT PK_CONVENIO PRIMARY KEY (ID_CONVENIO),
CONSTRAINT FK_CONVENIO_EMPRESA FOREIGN KEY (CIF_EMPRESA) REFERENCES EMPRESA (CIF_EMPRESA)
) COMMENT 'Tabla con la informacion del convenio';
-- ---------------------------------------

-- ------------------------
-- TABLA PRACTICA_EMPRESA_ALUMNO
-- ------------------------
CREATE TABLE ANEXAR (
ID_ANEXADO INT AUTO_INCREMENT NOT NULL COMMENT 'Identificador de anexar alumno, empresa y practica',
ID_PRACTICA INT NOT NULL COMMENT 'Identificador de LA PRACTICA',
CIF_EMPRESA VARCHAR (10) NOT NULL COMMENT 'Identificador de la empresa',
NIF_ALUMNO VARCHAR (9) NOT NULL COMMENT 'NIF del alumno',

CONSTRAINT PK_ANEXAR PRIMARY KEY (ID_ANEXADO),
CONSTRAINT FK_ANEXAR_PRACTICA FOREIGN KEY (ID_PRACTICA) REFERENCES PRACTICA (ID_PRACTICA),
CONSTRAINT FK_ANEXAR_EMPRESA FOREIGN KEY (CIF_EMPRESA) REFERENCES EMPRESA (CIF_EMPRESA),
CONSTRAINT FK_ANEXAR_ALUMNO FOREIGN KEY (NIF_ALUMNO) REFERENCES ALUMNO (NIF)
) COMMENT 'Tabla con la informacion de anexar alumno, empresa y practica';
-- ---------------------------------------

INSERT INTO POBLACION (CODIGO_POSTAL, NOMBRE, PROVINCIA) VALUES
(13230,'Membrilla', 'Ciudad Real'),
(13200,'Manzanares', 'Ciudad Real'),
(13240,'La Solana', 'Ciudad Real'),
(23400,'Ubeda', 'Jaen'),
(2640,'Almansa', 'Albacete'),
(13250,'Daimiel', 'Ciudad Real');

INSERT INTO CURSO (NOMBRE_CURSO, NOMBRE_ABREV, CLAVE, HORAS_FCT, ES_PUBLICO) VALUES
('2º CFGM Carrocería', '2CA', 'MVA21', 400, False),
('2º CFGM Electromecánica', '2EL', 'MVA22', 400, False),
('2º CFGM Sistemas MicroInformáticos y Redes', '2º SMR', 'IFC0221', 400, False),
('2º CFGS Desarrollo de Aplicaciones Multiplataforma', '2º DAM', 'IFCS02', 400, False),
('2º CFGS Técnico Superior en Automoción', '2º AUT', '', 400, False),
('2º FP Básica Informática y Comunicaciones', '2º FPB Inf', 'IFC1-10', 240, False),
('2º FP Básica Mantenimiento de Vehículos', '2º FPB Mec', 'TMV1-10', 240, False);

SELECT * FROM ALUMNO;
SELECT * FROM CURSO;