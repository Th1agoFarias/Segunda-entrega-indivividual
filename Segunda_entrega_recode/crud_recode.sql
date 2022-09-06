create database agenda;

use agenda;

CREATE TABLE Destino (
    id int auto_increment primary key,
    volta INT,
    ida INT,
    estado VARCHAR(40),
    cidade VARCHAR(40));
    
CREATE TABLE promocao (
    nome Varchar(40),
    valor float,
    id int PRIMARY KEY,
    fk_destino_id int);


select * from destinos ;
select * from contatos ;
select * from promocao ;