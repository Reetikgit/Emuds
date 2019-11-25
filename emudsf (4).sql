-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2019 at 04:33 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `emudsf`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc1`()
select * from teacher$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc2`()
select * from attendance$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Id` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Id`, `Name`, `Password`) VALUES
('26', 'Anupam Mishra', '123'),
('56', 'Reetik Chitragupt', '123');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `usn` varchar(20) NOT NULL,
  `Teacher_id` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `Subjectid` varchar(20) NOT NULL,
  `StudentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`usn`, `Teacher_id`, `status`, `date`, `Subjectid`, `StudentName`) VALUES
('1VA17IS004', 't101', 'A', '20-11-2019', '17CS50', 'Aishhwarya HM'),
('1VA17IS019', 't101', 'A', '20-11-2019', '17CS50', 'Harshitha '),
('1VA17IS026', 't101', 'A', '20-11-2019', '17CS50', 'Anupam Mishra'),
('1VA17IS030', 't101', 'A', '20-11-2019', '17CS50', 'Navaratna Hegde'),
('1VA17IS038', 't101', 'A', '20-11-2019', '17CS50', 'Reetik Chitragupt'),
('1VA17IS004', 't101', 'A', '19-11-2019', '17CS50', 'Aishhwarya HM'),
('1VA17IS019', 't101', 'A', '19-11-2019', '17CS50', 'Harshitha '),
('1VA17IS026', 't101', 'A', '19-11-2019', '17CS50', 'Anupam Mishra'),
('1VA17IS030', 't101', 'A', '19-11-2019', '17CS50', 'Navaratna Hegde'),
('1VA17IS038', 't101', 'A', '19-11-2019', '17CS50', 'Reetik Chitragupt'),
('1VA17IS004', 't102', 'P', '19-11-2019', '17CS52', 'Aishhwarya HM'),
('1VA17IS019', 't102', 'P', '19-11-2019', '17CS52', 'Harshitha '),
('1VA17IS026', 't102', 'P', '19-11-2019', '17CS52', 'Anupam Mishra'),
('1VA17IS030', 't102', 'P', '19-11-2019', '17CS52', 'Navaratna Hegde'),
('1VA17IS038', 't102', 'A', '19-11-2019', '17CS52', 'Reetik Chitragupt'),
('1VA17IS004', 't102', 'P', '20-11-2019', '17CS52', 'Aishhwarya HM'),
('1VA17IS019', 't102', 'P', '20-11-2019', '17CS52', 'Harshitha '),
('1VA17IS026', 't102', 'A', '20-11-2019', '17CS52', 'Anupam Mishra'),
('1VA17IS030', 't102', 'P', '20-11-2019', '17CS52', 'Navaratna Hegde'),
('1VA17IS038', 't102', 'P', '20-11-2019', '17CS52', 'Reetik Chitragupt'),
('1VA17IS004', 't103', 'P', '20-11-2019', '17CS51', 'Aishhwarya HM'),
('1VA17IS019', 't103', 'P', '20-11-2019', '17CS51', 'Harshitha '),
('1VA17IS026', 't103', 'A', '20-11-2019', '17CS51', 'Anupam Mishra'),
('1VA17IS030', 't103', 'A', '20-11-2019', '17CS51', 'Navaratna Hegde'),
('1VA17IS038', 't103', 'A', '20-11-2019', '17CS51', 'Reetik Chitragupt'),
('1VA17IS004', 't103', 'P', '20-11-2019', '17CS51', 'Aishhwarya HM'),
('1VA17IS019', 't103', 'P', '20-11-2019', '17CS51', 'Harshitha '),
('1VA17IS026', 't103', 'A', '20-11-2019', '17CS51', 'Anupam Mishra'),
('1VA17IS030', 't103', 'A', '20-11-2019', '17CS51', 'Navaratna Hegde'),
('1VA17IS038', 't103', 'A', '20-11-2019', '17CS51', 'Reetik Chitragupt'),
('1VA17IS004', 't103', 'P', '21-11-2019', '17CS51', 'Aishhwarya HM'),
('1VA17IS019', 't103', 'P', '21-11-2019', '17CS51', 'Harshitha '),
('1VA17IS026', 't103', 'A', '21-11-2019', '17CS51', 'Anupam Mishra'),
('1VA17IS030', 't103', 'A', '21-11-2019', '17CS51', 'Navaratna Hegde'),
('1VA17IS038', 't103', 'A', '21-11-2019', '17CS51', 'Reetik Chitragupt'),
('1VA17IS004', 't103', 'P', '21-11-2019', '17CS51', 'Aishhwarya HM'),
('1VA17IS019', 't103', 'P', '21-11-2019', '17CS51', 'Harshitha '),
('1VA17IS026', 't103', 'A', '21-11-2019', '17CS51', 'Anupam Mishra'),
('1VA17IS030', 't103', 'A', '21-11-2019', '17CS51', 'Navaratna Hegde'),
('1VA17IS038', 't103', 'A', '21-11-2019', '17CS51', 'Reetik Chitragupt'),
('1VA17CS050', 't202', 'P', '21-11-2019', '17CS50', 'Shreyansh '),
('1VA17CS050', 't201', 'P', '21-11-2019', '17CS51', 'Shreyansh '),
('1VA17IS004', 't102', 'P', '22-11-2019', '17CS52', 'Aishhwarya HM'),
('1VA17IS019', 't102', 'P', '22-11-2019', '17CS52', 'Harshitha '),
('1VA17IS026', 't102', 'P', '22-11-2019', '17CS52', 'Anupam Mishra'),
('1VA17IS030', 't102', 'P', '22-11-2019', '17CS52', 'Navaratna Hegde'),
('1VA17IS038', 't102', 'A', '22-11-2019', '17CS52', 'Reetik Chitragupt'),
('1VA17IS042', 't102', 'A', '22-11-2019', '17CS52', 'Samrudh GR'),
('1VA17IS004', 't101', 'A', '22-11-2019', '17CS50', 'Aishhwarya HM'),
('1VA17IS019', 't101', 'A', '22-11-2019', '17CS50', 'Harshitha '),
('1VA17IS026', 't101', 'A', '22-11-2019', '17CS50', 'Anupam Mishra'),
('1VA17IS030', 't101', 'A', '22-11-2019', '17CS50', 'Navaratna Hegde'),
('1VA17IS038', 't101', 'A', '22-11-2019', '17CS50', 'Reetik Chitragupt'),
('1VA17IS042', 't101', 'A', '22-11-2019', '17CS50', 'Samrudh GR'),
('1VA17IS004', 't103', 'P', '22-11-2019', '17CS51', 'Aishhwarya HM'),
('1VA17IS019', 't103', 'P', '22-11-2019', '17CS51', 'Harshitha '),
('1VA17IS026', 't103', 'A', '22-11-2019', '17CS51', 'Anupam Mishra'),
('1VA17IS030', 't103', 'P', '22-11-2019', '17CS51', 'Navaratna Hegde'),
('1VA17IS038', 't103', 'P', '22-11-2019', '17CS51', 'Reetik Chitragupt'),
('1VA17IS042', 't103', 'P', '22-11-2019', '17CS51', 'Samrudh GR');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `Name` varchar(11) NOT NULL,
  `Hod_id` varchar(11) NOT NULL,
  `branch_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE IF NOT EXISTS `exam` (
  `Exam_no` varchar(10) NOT NULL,
  `Exam_date` date NOT NULL,
  `Branch_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE IF NOT EXISTS `marks` (
  `USN` varchar(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `BranchID` varchar(20) NOT NULL,
  `SubjectId` varchar(20) NOT NULL,
  `IA1` int(5) NOT NULL,
  `IA2` int(5) NOT NULL,
  `IA3` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`USN`, `Name`, `BranchID`, `SubjectId`, `IA1`, `IA2`, `IA3`) VALUES
('1VA17IS030', 'Navaratna Hegde', 'ISE', '17CS50', 40, 39, 40),
('1VA17IS030', 'Navaratna Hegde', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS030', 'Navaratna Hegde', 'ISE', '17CS52', -1, -1, -1),
('1VA17IS038', 'Reetik Chitragupt', 'ISE', '17CS50', 40, 39, 40),
('1VA17IS038', 'Reetik Chitragupt', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS038', 'Reetik Chitragupt', 'ISE', '17CS52', -1, -1, -1),
('1VA17IS004', 'Aishhwarya HM', 'ISE', '17CS50', 35, 40, -1),
('1VA17IS004', 'Aishhwarya HM', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS004', 'Aishhwarya HM', 'ISE', '17CS52', -1, -1, -1),
('1VA17IS019', 'Harshitha ', 'ISE', '17CS50', 40, -1, -1),
('1VA17IS019', 'Harshitha ', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS019', 'Harshitha ', 'ISE', '17CS52', -1, -1, -1),
('1VA17IS026', 'Anupam Mishra', 'ISE', '17CS50', 40, 30, -1),
('1VA17IS026', 'Anupam Mishra', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS026', 'Anupam Mishra', 'ISE', '17CS52', -1, -1, -1),
('1VA17IS042', 'Samrudh GR', 'ISE', '17CS50', 40, -1, -1),
('1VA17IS042', 'Samrudh GR', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS042', 'Samrudh GR', 'ISE', '17CS52', -1, -1, -1),
('1VA17CS050', 'Shreyansh ', 'CSE', '17CS50', 30, 31, 35),
('1VA17CS050', 'Shreyansh ', 'CSE', '17CS51', -1, -1, -1),
('1VA17CS050', 'Shreyansh ', 'CSE', '17CS52', -1, -1, -1),
('1VA17IS045', 'Suraj  s', 'ISE', '17CS50', -1, -1, -1),
('1VA17IS045', 'Suraj  s', 'ISE', '17CS51', -1, -1, -1),
('1VA17IS045', 'Suraj  s', 'ISE', '17CS52', -1, -1, -1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `USN` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Year` varchar(10) NOT NULL,
  `Branch_id` varchar(10) NOT NULL,
  `Class_id` varchar(10) NOT NULL,
  `Teacher_id` varchar(10) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Phone_No` bigint(12) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Subject_id` varchar(10) NOT NULL,
  `Marks_id` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`USN`, `Name`, `Year`, `Branch_id`, `Class_id`, `Teacher_id`, `DOB`, `Phone_No`, `Email`, `Subject_id`, `Marks_id`, `Password`) VALUES
('1VA17CS050', 'Shreyansh ', '2017', 'CSE', 'CSE01', 't201', '7/10/99', 95451286454, 'shreyansh@gmail.com', '17CS', '1VA17CS050', '123'),
('1VA17IS004', 'Aishhwarya HM', '2017', 'ISE', 'ISE', 't102', '8/6/2000', 9776656224, 'aish@gmail.com', '17CS', '1VA17IS004', '1va17is004'),
('1VA17IS019', 'Harshitha ', '2017', 'ISE', 'ISE', 't101', '19/5/99', 9445567778, 'harshitha@gmail.com', '17CS', '1VA17IS019', '1va17is019'),
('1VA17IS026', 'Anupam Mishra', '2017', 'ISE', 'ISE', 't103', '25/9/99', 94567777888, 'anupam@gmail.com', '17CS', '1VA17IS026', '1va17is026'),
('1VA17IS030', 'Navaratna Hegde', '2017', 'ISE', 'ISE', 't101', '9/9/99', 8310829872, 'navaratna@gmail.com', '17CS', '1VA17IS030', '1va17is030'),
('1VA17IS038', 'Reetik Chitragupt', '2017', 'ISE', 'ISE', 't101', '07/2/99', 7355670645, 'reetikchitragupt@gmail.com', '17CS', '1VA17IS038', '1VA17IS038'),
('1VA17IS042', 'Samrudh GR', '2017', 'ISE', 'ISE01', 't101', '6/8/99', 94567594147, 'samrudh@gmail.com', '17CS', '1VA17IS042', '1va17is042'),
('1VA17IS045', 'Suraj  s', '20147', 'ISE', '17IS', 't101', '9/8/99', 96453125552, 'surajs045.17IS@saividya.ac.in', '17CS', '1VA17IS045', '1va17is045');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `SubjectId` varchar(10) NOT NULL,
  `sb1` varchar(10) NOT NULL,
  `sb2` varchar(10) NOT NULL,
  `sb3` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `BranchId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`SubjectId`, `sb1`, `sb2`, `sb3`, `Name`, `BranchId`) VALUES
('17CS', '17CS50', '17CS51', '17CS52', 'CSE', 'CSE'),
('17CS', '17CS50', '17CS51', '17CS52', 'ISE', 'ISE'),
('17CIV', '17CIV50', '17CIV51', '17CIV52', 'CIVIL', 'CIVIL');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Branch_id` varchar(10) NOT NULL,
  `classId` varchar(10) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `JoiningYear` varchar(10) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  `SubjectTeachId` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `Name`, `Branch_id`, `classId`, `DOB`, `PhoneNo`, `Email`, `JoiningYear`, `Designation`, `SubjectTeachId`, `Password`) VALUES
('fg', 'h', 'ISE', 'bhg', '5/4/4', '78521689', 'rdgfc', '44', 'ISE', '17CS50', 'fg'),
('fttfq', 'yguyg', 'ISE', '54', '5/7/85', '684553212', 'tgh', '5465', 'ISE', '17CS50', 'fttfq'),
('t101', 'Prof. Mamtha', 'ISE', 'ise', '5/3/90', '9456622224', 'mam@gmail.com', '2014-05-05', 'Teacher', '17CS50', 't101'),
('t102', 'Prof.VrindaShetty', 'ISE', 'ise', '1990-11-02', '46531654', 'vrinda@gmail.com', '2011-05-05', 'HOD', '17CS52', 't102'),
('t103', 'Prof. Abhijeet', 'ISE', 'ise', '12/3/91', '9456789462', 'abhijeethv@gmail.com', '2014-05-05', 'Teacher', '17CS51', 't103'),
('t104', 'Prof Neelambika ', 'ISE', 'ise01', '9/9/90', '9453222211', 'neelambika@gmail.com', '2017', 'ISE', '17CS50', 't104'),
('t201', 'Prof. Deeksha Hegde', 'CSE', 'cse', '1993-11-01', '945667889', 'something@gmail.com', '2011-05-05', 'Teacher', '17CS51', 't201'),
('t202', 'Prof Santosh', 'CSE', 'cse', '9/3/2017', '9455661233', 'santosh@gmail.com', '2019', 'Teacher', '17CS50', 't202'),
('t203', 'Prof AnanthPadma', 'CSE', 'cse', '10/5/90', '9781564388', 'hodcse@gmail.com', '2018', 'HOD', '17CS52', 't203'),
('t301', 'Akshay Kumar', 'CIVIL', 'civ', '6/9/90', '9996663332', 'akshay@gmail.com', '2014', 'Teacher', '17CIV50', 't301'),
('t302', 'Sumam', 'CIVIL', 'civ', '6/3/90', '9456125213', 'sumam@gmail.com', '2015', 'Teacher', '17CIV51', 't302'),
('t303', 'Shreekumari', 'CIVIL', 'civ', '6/3/89', '9456125213', 'shreekumari@gmail.com', '2013', 'HOD', '17CIV52', 't303');

-- --------------------------------------------------------

--
-- Table structure for table `teacherattendance`
--

CREATE TABLE IF NOT EXISTS `teacherattendance` (
  `teacherid` varchar(10) NOT NULL,
  `Hodid` varchar(10) NOT NULL,
  `status` varchar(5) NOT NULL,
  `date` varchar(15) NOT NULL,
  `teachername` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacherattendance`
--

INSERT INTO `teacherattendance` (`teacherid`, `Hodid`, `status`, `date`, `teachername`) VALUES
('t101', 't102', 'A', '22-11-2019', 'Prof. Mamtha'),
('t102', 't102', 'P', '22-11-2019', 'Prof.VrindaShetty'),
('t103', 't102', 'P', '22-11-2019', 'Prof. Abhijeet'),
('t104', 't102', 'A', '22-11-2019', 'Prof Neelambika ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
 ADD PRIMARY KEY (`Hod_id`), ADD UNIQUE KEY `branch_id` (`branch_id`), ADD UNIQUE KEY `Name` (`Name`), ADD KEY `Hod_id` (`Hod_id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
 ADD PRIMARY KEY (`Exam_no`), ADD KEY `exam_ibfk_1` (`Branch_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`USN`), ADD KEY `Branch_id` (`Branch_id`), ADD KEY `Marks_id` (`Marks_id`), ADD KEY `Teacher_id` (`Teacher_id`), ADD KEY `Subject_id` (`Subject_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
 ADD KEY `Teacher_id` (`BranchId`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
 ADD PRIMARY KEY (`teacher_id`,`classId`), ADD KEY `teacher_ibfk_1` (`Branch_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `branch`
--
ALTER TABLE `branch`
ADD CONSTRAINT `branch_ibfk_1` FOREIGN KEY (`Hod_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE NO ACTION;

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`Branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
