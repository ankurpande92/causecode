-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 20, 2016 at 08:20 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `CauseCode`
--

-- --------------------------------------------------------

--	
-- Table structure for table `ZIPCODE`
--
CREATE TABLE  `CauseCode`.`ZIPCODE` (
`ZIPCODE_ID` INT( 6 ) NOT NULL ,
`STATE` VARCHAR( 20 ) NOT NULL ,
`COUNTRY` VARCHAR( 20 ) NOT NULL ,
`LATITUDE` DECIMAL( 9, 6 ) NOT NULL ,
`LONGITUDE` DECIMAL( 9, 6 ) NOT NULL ,
PRIMARY KEY)(ZIPCODE_ID)
) ENGINE = INNODB; DEFAULT CHARSET=latin1 COMMENT='Data about zipcode ant its lat and long';

--
-- Dumping data for table `ZIPCODE_DATA`
--

INSERT INTO  `CauseCode`.`zipcode` (
`zipcode_id` ,
`state` ,
`country` ,
`latitude` ,
`longitude`
)
VALUES (
'10451',  'NY',  'US',  '40.84',  '-73.87'
);

INSERT INTO  `CauseCode`.`zipcode` (
`zipcode_id` ,
`state` ,
`country` ,
`latitude` ,
`longitude`
)
VALUES (
'933',  'SAN JUAN',  'PR, US',  '18.4',  '-66.06'
);

