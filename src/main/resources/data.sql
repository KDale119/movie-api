-- insert into directors (firstname, lastname, dateofbirth) values ('James', 'Cameron', '1954-08-16');
-- insert into directors (firstname, lastname, dateofbirth) values ('J.J.', 'Abrams', '1966-06-27');
-- insert into directors (firstname, lastname, dateofbirth) values ('Stephen', 'Spielberg', '1946-12-18');
-- insert ignore into directors (first_name, last_name, date_of_birth) values ('James', 'Cameron', '1954-08-16');

insert into ratings (rating, description) values ('G', 'General Audiences');
insert into ratings (rating, description) values ('PG', 'Parental Guidance Suggested');
insert into ratings (rating, description) values ('PG-13', 'Parents Strongly Cautioned');
insert into ratings (rating, description) values ('R', 'Restricted');

insert into genres (genre) values ('Action');
insert into genres (genre) values ('Animation');
insert into genres (genre) values ('Comedy');
insert into genres (genre) values ('Sci-Fi');
insert into genres (genre) values ('Drama, Sci-Fi');

-- insert into actors (firstname, lastname, dateofbirth) values ('Sam', 'Worthington', '1976-08-02');
-- insert into actors (firstname, lastname, dateofbirth) values ('Zoe', 'Saldana', '1978-06-19');
-- insert into actors (firstname, lastname, dateofbirth) values ('Sigourney', 'Weaver', '1949-10-08');
-- insert into actors (firstname, lastname, dateofbirth) values ('John', 'Cho', '1972-06-16');
-- insert into actors (firstname, lastname, dateofbirth) values ('Chris', 'Pine', '1980-08-26');
-- insert into actors (firstname, lastname, dateofbirth) values ('Richard', 'Dreyfuss', '1947-10-29');


-- INSERT INTO movies (moviename, movielength, releasedate, directorid, ratingid, genreid, trailerurl)
-- values ('Avatar', 162, '2009-12-18', 1, 3, 3, 'https://www.youtube.com/embed/5PSNL1qE6VY');
-- INSERT INTO movies (moviename, movielength, releasedate, directorid, ratingid, genreid, trailerurl)
-- values ('Star Trek', 127, '2009-05-08', 2, 3, 3, 'https://www.youtube.com/embed/3PM1pvOzn_w');
-- INSERT INTO movies (moviename, movielength, releasedate, directorid, ratingid, genreid, trailerurl)
-- values ('Close Encounters of the Third Kind', 135, '1977-11-16', 3, 2, 4, 'https://www.youtube.com/embed/dSpQ3G08k48');

-- INSERT INTO movie_actors (movieid, actorid) VALUES (1, 1);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (1, 2);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (1, 3);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (2, 3);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (2, 4);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (2, 5);
-- INSERT INTO movie_actors (movieid, actorid) VALUES (3, 6);
