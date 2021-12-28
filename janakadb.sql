-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2018 at 09:55 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `janakadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `advance`
--

CREATE TABLE `advance` (
  `adv_id` int(11) NOT NULL,
  `supplierID` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `paid` int(11) NOT NULL DEFAULT '0',
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `advance`
--

INSERT INTO `advance` (`adv_id`, `supplierID`, `amount`, `paid`, `date`) VALUES
(1, 1, 1000, 0, '2018-06-30'),
(2, 1, 2000, 0, '2018-05-30'),
(3, 1, 5000, 0, '2018-07-30'),
(4, 2, 1005, 0, '2018-07-01');

-- --------------------------------------------------------

--
-- Table structure for table `arrears`
--

CREATE TABLE `arrears` (
  `id` int(11) NOT NULL,
  `supplierID` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  `valid` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `arrears`
--

INSERT INTO `arrears` (`id`, `supplierID`, `amount`, `date`, `valid`) VALUES
(1, 2, 1000, '2018-07-01', 1),
(2, 1, 1000, '2018-07-01', 1),
(3, 3, 5000, '2018-07-10', 1),
(4, 4, 9000, '2018-07-10', 1),
(5, 2, 5440, '2018-01-01', 1),
(6, 2, 5440, '2018-08-01', 1),
(7, 4, 9000, '2018-08-10', 1),
(8, 1, 17890, '2018-09-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `credit_debit`
--

CREATE TABLE `credit_debit` (
  `id` int(11) NOT NULL,
  `supplier_ID` int(11) NOT NULL,
  `reason` varchar(150) DEFAULT NULL,
  `quantity` double NOT NULL,
  `creditOrDebit` varchar(6) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `daily_record`
--

CREATE TABLE `daily_record` (
  `recordID` int(11) NOT NULL,
  `supplierID` int(11) NOT NULL,
  `date` date NOT NULL,
  `final_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daily_record`
--

INSERT INTO `daily_record` (`recordID`, `supplierID`, `date`, `final_amount`) VALUES
(1, 1, '2018-06-01', 110),
(2, 1, '2018-06-10', 52),
(3, 1, '2018-06-30', 50),
(4, 4, '2018-06-30', 90),
(5, 4, '2018-05-20', 50),
(6, 4, '2018-06-01', 20);

-- --------------------------------------------------------

--
-- Table structure for table `fertilizer`
--

CREATE TABLE `fertilizer` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `validFrom` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fertilizer`
--

INSERT INTO `fertilizer` (`id`, `name`, `price`, `validFrom`) VALUES
(1, 'H1N1', 2500, '2018-06-30'),
(2, '880', 2000, '2018-06-30'),
(6, '881', 2200, '2018-07-01'),
(9, '85', 2000, '2018-12-30');

-- --------------------------------------------------------

--
-- Table structure for table `fertilizer_record`
--

CREATE TABLE `fertilizer_record` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `feriilizer_Id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `NoOfMonth` int(11) NOT NULL,
  `date` date NOT NULL,
  `toDate` date NOT NULL,
  `monthly_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fertilizer_record`
--

INSERT INTO `fertilizer_record` (`id`, `supplier_id`, `feriilizer_Id`, `amount`, `NoOfMonth`, `date`, `toDate`, `monthly_price`) VALUES
(3, 4, 1, 4, 2, '2018-05-30', '2018-07-01', 5000),
(4, 4, 2, 3, 2, '2018-07-30', '2018-09-01', 3000),
(5, 1, 1, 2, 2, '2018-05-30', '2018-07-01', 2500),
(6, 1, 2, 1, 1, '2018-06-30', '2018-07-01', 2000),
(7, 1, 1, 1, 1, '2018-07-03', '2018-08-01', 2500);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `birthDay` date NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `full_name`, `user_name`, `nic`, `birthDay`, `password`) VALUES
(1, 'jayantha pushpakumara', 'jaya', '930802557v', '1993-03-20', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `supplier_ID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `telephone` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id`, `supplier_ID`, `name`, `telephone`) VALUES
(1, 1, 'jayantha', ''),
(2, 2, 'saman', '1234'),
(3, 3, 'Thushara', '0713512410'),
(4, 4, 'Gunapala', '0457917234');

-- --------------------------------------------------------

--
-- Table structure for table `tbldate`
--

CREATE TABLE `tbldate` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbldate`
--

INSERT INTO `tbldate` (`id`, `date`) VALUES
(1, '2018-08-01');

-- --------------------------------------------------------

--
-- Table structure for table `tea_packet`
--

CREATE TABLE `tea_packet` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tea_packet`
--

INSERT INTO `tea_packet` (`id`, `supplier_id`, `quantity`, `date`) VALUES
(1, 1, 1, '2018-06-30'),
(2, 3, 5, '2018-06-01'),
(3, 2, 2, '2018-05-01'),
(4, 4, 3, '2018-07-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advance`
--
ALTER TABLE `advance`
  ADD PRIMARY KEY (`adv_id`),
  ADD KEY `supplierID` (`supplierID`);

--
-- Indexes for table `arrears`
--
ALTER TABLE `arrears`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplierID` (`supplierID`);

--
-- Indexes for table `credit_debit`
--
ALTER TABLE `credit_debit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_ID` (`supplier_ID`);

--
-- Indexes for table `daily_record`
--
ALTER TABLE `daily_record`
  ADD PRIMARY KEY (`recordID`),
  ADD KEY `supplierID` (`supplierID`);

--
-- Indexes for table `fertilizer`
--
ALTER TABLE `fertilizer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `fertilizer_record`
--
ALTER TABLE `fertilizer_record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `feriilizer_Id` (`feriilizer_Id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `supplier_ID` (`supplier_ID`);

--
-- Indexes for table `tbldate`
--
ALTER TABLE `tbldate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tea_packet`
--
ALTER TABLE `tea_packet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `advance`
--
ALTER TABLE `advance`
  MODIFY `adv_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `arrears`
--
ALTER TABLE `arrears`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `credit_debit`
--
ALTER TABLE `credit_debit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `daily_record`
--
ALTER TABLE `daily_record`
  MODIFY `recordID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `fertilizer`
--
ALTER TABLE `fertilizer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `fertilizer_record`
--
ALTER TABLE `fertilizer_record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbldate`
--
ALTER TABLE `tbldate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tea_packet`
--
ALTER TABLE `tea_packet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `advance`
--
ALTER TABLE `advance`
  ADD CONSTRAINT `advance_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `arrears`
--
ALTER TABLE `arrears`
  ADD CONSTRAINT `arrears_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `credit_debit`
--
ALTER TABLE `credit_debit`
  ADD CONSTRAINT `credit_debit_ibfk_1` FOREIGN KEY (`supplier_ID`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `daily_record`
--
ALTER TABLE `daily_record`
  ADD CONSTRAINT `daily_record_ibfk_1` FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `fertilizer_record`
--
ALTER TABLE `fertilizer_record`
  ADD CONSTRAINT `fertilizer_record_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  ADD CONSTRAINT `fertilizer_record_ibfk_2` FOREIGN KEY (`feriilizer_Id`) REFERENCES `fertilizer` (`id`);

--
-- Constraints for table `tea_packet`
--
ALTER TABLE `tea_packet`
  ADD CONSTRAINT `tea_packet_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
