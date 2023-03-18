CREATE SCHEMA gestiMed DEFAULT CHARACTER SET utf8mb4 ;

use gestiMed;

CREATE TABLE medico (
dni varchar(255) NOT NULL,
nombre varchar(255),
apellidos varchar(255),
email varchar(255),
contrasenya varchar(255),
numContacto varchar(255),
turno varchar(255),
primary key(dni)
);

CREATE TABLE enfermero(
dni varchar(255) NOT NULL,
nombre varchar(255),
apellidos varchar(255),
email varchar(255),
contrasenya varchar(255),
numContacto varchar(255),
turno varchar(255),
primary key(dni)
);

CREATE TABLE medicamento(
id varchar(255) NOT NULL,
nombre varchar(255),
cantidad integer,
pedir boolean,
intervalo integer,
primary key(id)
);

CREATE TABLE tratamiento(
nombre varchar(255),
descripcion varchar(255), 
solucion varchar(255),
medicamento varchar(255),
primary key(nombre),
foreign key(medicamento) references medicamento(id)
);

CREATE TABLE paciente(
sip varchar(255) NOT NULL,
nombre varchar(255),
apellidos varchar(255),
numContacto varchar(255),
nacimiento datetime,
tratamiento varchar(255),
urgencia varchar(255),
primary key(sip),
foreign key(tratamiento) references tratamiento(nombre)
);

CREATE TABLE trata(
dni_medico varchar(255),
sip_paciente varchar(255),
primary key(dni_medico, sip_paciente),
foreign key (dni_medico) references medico(dni),
foreign key (sip_paciente) references paciente(sip)
);

CREATE TABLE cura(
dni_enfermero varchar(255),
sip_paciente varchar (255),
primary key(dni_enfermero, sip_paciente),
foreign key (dni_enfermero) references enfermero(dni),
foreign key (sip_paciente) references paciente(sip)
);

