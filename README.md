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

Run using tomcat 7
and access the url

http://localhost:6060/movie/api/movies/search?page=1&per_page=10&Title=spider
