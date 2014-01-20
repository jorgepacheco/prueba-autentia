BEGIN;

create table cursos (id_curso int not null,
    titulo varchar(255) not null,
    activo boolean not null,
    nivel varchar(100) not null,
    horas int not null,
    id_profesor int,
    temario blob,
    filename varchar(255),
    primary key (id_curso));
   
    
create table profesores (id_profesor int not null,
    nombre varchar(100) not null,
    apellidos varchar(100) not null,
    primary key (id_profesor));
    
ALTER TABLE cursos
ADD FOREIGN KEY (id_profesor) 
REFERENCES profesores(id_profesor);


CREATE SEQUENCE seq_id_curso START WITH 20 INCREMENT BY 1;



COMMIT;