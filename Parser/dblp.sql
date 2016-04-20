

CREATE DATABASE IF NOT EXISTS dblp;
USE dblp;


DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `name` varchar(100) DEFAULT NULL,
  `paper_key` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `citation`;
CREATE TABLE `citation` (
  `paper_cite_key` varchar(200) DEFAULT NULL,
  `paper_cited_key` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `conference`;
CREATE TABLE `conference` (
  `conf_key` varchar(100) DEFAULT NULL,
  `name` text,
  `detail` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `title` text,
  `year` int(11) DEFAULT '0',
  `conference` text,
  `paper_key` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
