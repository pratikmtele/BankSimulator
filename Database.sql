CREATE DATABASE bankmanagmentsystem;

CREATE TABLE `account` (
  `Acc_no` varchar(15) NOT NULL,
  `Cust_ID` varchar(50) NOT NULL,
  `Acc_type` varchar(50) NOT NULL,
  `Balance` varchar(100) NOT NULL,
  PRIMARY KEY (`Acc_no`)
);


CREATE TABLE `admin` (
  `Admin_ID` varchar(15) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_add` varchar(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`Admin_ID`)
);


CREATE TABLE `customer` (
  `Cust_ID` varchar(15) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_add` varchar(11) NOT NULL,
  `DOB` varchar(50) NOT NULL,
  `EmailID` varchar(50) NOT NULL,
  `Gender` varchar(8) DEFAULT NULL
)


CREATE TABLE `transactions` (
  `Trans_ID` varchar(15) NOT NULL,
  `Acc_no` varchar(50) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Particulars` varchar(50) NOT NULL,
  `Amount` varchar(100) NOT NULL,
  PRIMARY KEY (`Trans_ID`)
);