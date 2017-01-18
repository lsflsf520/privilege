
drop DATABASE if EXISTS oc_ralasafe;
CREATE DATABASE oc_ralasafe;
USE oc_ralasafe;

DROP TABLE IF EXISTS `ralasafe_sequence`;
CREATE TABLE `ralasafe_sequence` (
  `currentValue` int(11) default NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `name` varchar(100) NOT NULL,
  `description` varchar(500) default NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `applicationusertype`;
CREATE TABLE `applicationusertype` (
  `appName` varchar(100) NOT NULL,
  `userTypeName` varchar(100) NOT NULL,
  `userMetadataStr` varchar(1000) default NULL,
  PRIMARY KEY  (`appName`,`userTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `name` varchar(100) NOT NULL,
  `description` varchar(500) default NULL,
  `userMetadataXML` varchar(4000) default NULL,
  PRIMARY KEY  (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

