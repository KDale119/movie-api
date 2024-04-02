insert into genres (genre) values ('Action');--1
insert into genres (genre) values ('Comedy');--2
insert into genres (genre) values ('Sci-Fi');--3
insert into genres (genre) values ('Drama');--4



insert into ratings (rating,description) values ('G', 'General Audiences');--1
insert into ratings (rating,description) values ('PG', 'Parental Guidance Suggested');--2
insert into ratings (rating,description) values ('PG-13', 'Parents Strongly Cautioned');--3
insert into ratings (rating,description) values ('R', 'Restricted');--4

-- actors,directors, movies, movieactors


insert into actors (firstname, lastname, dateofbirth) values ('Morgan', 'Freeman', '1937-06-01'); --1
insert into actors (firstname, lastname, dateofbirth) values ('Jet', 'Li', '1963-04-26'); --2

insert into actors (firstname, lastname, dateofbirth) values ('Milla', 'Jovovich', '1975-12-17'); --3
insert into actors (firstname, lastname, dateofbirth) values ('Dustin', 'Hoffman', '1937-08-08'); --4

insert into actors (firstname, lastname, dateofbirth) values ('Brittany', 'Murphy', '1977-11-10');--5
insert into actors (firstname, lastname, dateofbirth) values ('Dakota', 'Fanning', '1994-02-23');--6


insert into directors (firstname, lastname, dateofbirth) values ('Louis', 'Leterrier', '1973-06-17'); --1
insert into directors (firstname, lastname, dateofbirth) values ('Luc', 'Besson', '1959-03-18');--2
insert into directors (firstname, lastname, dateofbirth) values ('Boaz', 'Yakin', '1965-06-20');--3


insert into movies (movieName, movieLength, releaseDate, trailerUrl, directorid, genreid, ratingid) values ('Unleashed', 2, '2005-05-13', 'https://www.youtube.com/embed/9UKilYzrQH4?si=HYoP4t6PaxxfeZ6l', 1, 1, 4);--1
insert into movies (movieName, movieLength, releaseDate, trailerUrl, directorid, genreid, ratingid) values ('The Messenger: Joan of Arc', 2.5, '1999-10-18','https://www.youtube.com/embed/rWVO2cDKeng?si=WRGl6PB15fe4vUG4', 2, 1, 4);--2
insert into movies (movieName, movieLength, releaseDate, trailerUrl, directorid, genreid, ratingid) values ('Uptown Girls', 1.5, '2003-08-15', 'https://www.youtube.com/embed/ftSY4DW5tEk?si=fIEtSBrvNdByaN9D', 3, 2, 3);--2



-- add dobs