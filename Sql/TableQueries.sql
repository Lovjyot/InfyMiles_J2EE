create database InfyMiles;

use InfyMiles;

create table Register (
emailId varchar(50) Primary key,
name varchar(30),
password varchar(20),
userType varchar(20)
);

truncate table register;
Alter Table register ADD city varchar(20) not null AFTER phoneNumber, Add state varchar(20) not null AFTER city,
 Add zipcode varchar(5) not null AFTER state;

, phoneNumber varchar(10) not null,city varchar(20) not null,state varchar(20) not null, 
zipcode varchar(5) not null; 
desc register;
Insert  into Register values('divyank08jain@gmail.com','Divyank','12345','customer','2951 S king drive','1234567890','chicago','IL','60606');
select * from Register;




CREATE TABLE `cars` (
  `carId` int(11) NOT NULL,
  `carName` varchar(50) DEFAULT NULL,
  `carCategory` varchar(20) DEFAULT NULL,
  `carBrandName` varchar(20) DEFAULT NULL,
  `carModel` varchar(20) DEFAULT NULL,
  `carMileage` varchar(20) DEFAULT NULL,
  `carProductionYear` varchar(20) DEFAULT NULL,
  `carColor` varchar(20) DEFAULT NULL,
  `carImagePath` varchar(200) DEFAULT NULL,
  `carPrice` varchar(20) DEFAULT NULL,
  `carReservationStatus` int(11) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`carId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




create table Orders(
orderId int  Primary key,
carId int,
emailId varchar(30),
orderDate varchar(20),
startDate varchar(20),
endDate varchar(20),
amount varchar(20),
cardNumber varchar(20),
address varchar(200),
status varchar(20),
licenseId varchar(20),
paymentMethod varchar(20)
);