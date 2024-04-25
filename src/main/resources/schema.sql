create table Film
(
    id integer auto_increment not null,
    filmNavn varchar(255),
    fornavn varchar (255),
    etternavn varchar (255),
    tlfnr varchar(20),
    epost varchar(255),
    antall integer,
    primary key (id)
);