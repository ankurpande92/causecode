-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 20, 2016 at 08:26 AM
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
-- Table structure for table `store`
--

CREATE TABLE  `CauseCode`.`store` (
`STORE_ID` INT( 6 ) NOT NULL ,
`STORE_NAME` VARCHAR( 20 ) NOT NULL ,
`STORE_ADDRESS` VARCHAR( 20 ) NOT NULL ,
`LATITUDE` DECIMAL( 9, 6 ) NOT NULL ,
`LONGITUDE` DECIMAL( 9, 6 ) NOT NULL ,
`ZIPCODE_ID` INT( 6 ) NOT NULL,
PRIMARY KEY)(STORE_ID)
) ENGINE = INNODB COMMENT =  'One to many relation table';


ALTER TABLE  `store` 
ADD CONSTRAINT  `zipcode_store_relation_ibfk_2` FOREIGN KEY (  `ZIPCODE_ID` ) REFERENCES  `zipcode` (  `zipcode_id` ) 


--
-- Dumping data for table `Store_Data`
--


INSERT INTO  `causecode`.`store` (
`STORE_ID` ,
`STORE_NAME` ,
`STORE_ADDRESS` ,
`LATITUDE` ,
`LONGITUDE` ,
`ZIPCODE_ID`
)
VALUES (
'55',  'Stationary',  'Street US',  '40.67',  '-89.45',  '10451'
);

INSERT INTO  `causecode`.`store` (
`STORE_ID` ,
`STORE_NAME` ,
`STORE_ADDRESS` ,
`LATITUDE` ,
`LONGITUDE` ,
`ZIPCODE_ID`
)
VALUES (
'11',  'Hotel Shop',  'CAS US',  '18.67',  '-66.45',  '10451'
);

INSERT INTO  `causecode`.`store` (
`STORE_ID` ,
`STORE_NAME` ,
`STORE_ADDRESS` ,
`LATITUDE` ,
`LONGITUDE` ,
`ZIPCODE_ID`
)
VALUES (
'22',  'Mac',  'NA-US-NJ-WHITEHOUSE',  '40.62',  '-74.76'  '10451'
);


