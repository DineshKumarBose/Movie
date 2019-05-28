# Movie
Create a webapp maven project
Create mysql database 'Movies' set username root and password ''(empty)
Create table with below query

CREATE TABLE `Movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `imdbid` varchar(255) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1

insert some records in the table

insert into Movie(Title,imdbid,poster,type,year) values('spider man','imdb1','https://spiderman.com/spider.png','movie',2009);
insert into Movie(Title,imdbid,poster,type,year) values('super man','imdb13','https://spiderman.com/superman.png','movie',2019);
insert into Movie(Title,imdbid,poster,type,year) values('the spider man','imdb15','https://spiderman.com/thespiderman.png','movie',1909);
insert into Movie(Title,imdbid,poster,type,year) values('spy man','imdb13','https://spiderman.com/spyman.png','movie',1923);

Run using tomcat 7
and access the url

http://localhost:6060/movie/api/movies/search?page=1&per_page=10&Title=spider
