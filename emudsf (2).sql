-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2019 at 02:42 PM
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
  `Subject_id` varchar(10) NOT NULL,
  `Teacher_id` varchar(10) NOT NULL,
  `Classes_Done` int(11) NOT NULL,
  `Classes_attended` int(11) NOT NULL,
  `Percentage` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `Subjectid` varchar(20) NOT NULL,
  `StudentName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`usn`, `Subject_id`, `Teacher_id`, `Classes_Done`, `Classes_attended`, `Percentage`, `status`, `date`, `Subjectid`, `StudentName`) VALUES
('1va17is004', '17cs', 't201', 50, 20, '20', 'P', '01-11-2019', '1va17cs51', 'Aishwarya'),
('1va17is005', '17cs', 't201', 50, 20, '20', 'P', '01-11-2019', '1va17cs51', 'Arjun'),
('1va17is019', '17cs', 't201', 50, 20, '20', 'P', '01-11-2019', '1va17cs51', 'Harshita '),
('1va17is030', '17cs', 't201', 50, 20, '20', 'P', '01-11-2019', '1va17cs51', 'Navaratna'),
('1va17is038', '17cs', 't201', 50, 20, '20', 'P', '01-11-2019', '1va17cs51', 'Reetik chitragupt'),
('s100', '17cs', 't201', 50, 20, '20', 'A', '01-11-2019', '1va17cs51', 'Reetik'),
('s101', '17cs', 't201', 50, 20, '20', 'A', '01-11-2019', '1va17cs51', 'Anupam'),
('s102', '17cs', 't201', 50, 20, '20', 'A', '01-11-2019', '1va17cs51', 'Bhagat'),
('s103', '17cs', 't201', 50, 20, '20', 'A', '01-11-2019', '1va17cs51', 'Tarun'),
('s104', '17cs', 't201', 50, 20, '20', 'A', '01-11-2019', '1va17cs51', 'Atul'),
('1va17is004', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Aishwarya'),
('1va17is005', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Arjun'),
('1va17is019', '17cs', 't201', 50, 20, '20', 'A', '02-11-2019', '1va17cs51', 'Harshita '),
('1va17is030', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Navaratna'),
('1va17is038', '17cs', 't201', 50, 20, '20', 'A', '02-11-2019', '1va17cs51', 'Reetik chitragupt'),
('s100', '17cs', 't201', 50, 20, '20', 'A', '02-11-2019', '1va17cs51', 'Reetik'),
('s101', '17cs', 't201', 50, 20, '20', 'A', '02-11-2019', '1va17cs51', 'Anupam'),
('s102', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Bhagat'),
('s103', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Tarun'),
('s104', '17cs', 't201', 50, 20, '20', 'P', '02-11-2019', '1va17cs51', 'Atul'),
('1va17cs036', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Rakesh'),
('1va17is004', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Aishwarya'),
('1va17is005', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Arjun'),
('1va17is019', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Harshita '),
('1va17is030', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Navaratna'),
('1va17is038', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Reetik chitragupt'),
('s100', '17cs', 't202', 50, 20, '20', 'P', '01-11-2019', '1va17cs53', 'Reetik'),
('s101', '17cs', 't202', 50, 20, '20', 'A', '01-11-2019', '1va17cs53', 'Anupam'),
('s102', '17cs', 't202', 50, 20, '20', 'A', '01-11-2019', '1va17cs53', 'Bhagat'),
('s103', '17cs', 't202', 50, 20, '20', 'A', '01-11-2019', '1va17cs53', 'Tarun'),
('s104', '17cs', 't202', 50, 20, '20', 'A', '01-11-2019', '1va17cs53', 'Atul'),
('1va17is004', '17cs', 't200', 50, 20, '20', 'P', '01-11-2019', '1va17cs50', 'Aishwarya'),
('1va17is005', '17cs', 't200', 50, 20, '20', 'P', '01-11-2019', '1va17cs50', 'Arjun'),
('1va17is010', '17cs', 't200', 50, 20, '20', 'P', '01-11-2019', '1va17cs50', 'Manu'),
('1va17is019', '17cs', 't200', 50, 20, '20', 'A', '01-11-2019', '1va17cs50', 'Harshita '),
('1va17is030', '17cs', 't200', 50, 20, '20', 'A', '01-11-2019', '1va17cs50', 'Navaratna'),
('1va17is038', '17cs', 't200', 50, 20, '20', 'P', '01-11-2019', '1va17cs50', 'Reetik chitragupt'),
('1va17is054', '17cs', 't200', 50, 20, '20', 'A', '01-11-2019', '1va17cs50', 'Shreyas'),
('1va17cs033', '17cs', 't201', 50, 20, '20', 'A', '16-11-2019', '1va17cs51', 'Siddhnat'),
('1va17cs035', '17cs', 't201', 50, 20, '20', 'A', '16-11-2019', '1va17cs51', 'Shreyansh'),
('1va17cs036', '17cs', 't201', 50, 20, '20', 'A', '16-11-2019', '1va17cs51', 'Rakesh'),
('1va17is004', '17cs', 't203', 50, 20, '20', 'P', '17-11-2019', '1va17cs54', 'Aishwarya'),
('1va17is005', '17cs', 't203', 50, 20, '20', 'P', '17-11-2019', '1va17cs54', 'Arjun'),
('1va17is010', '17cs', 't203', 50, 20, '20', 'P', '17-11-2019', '1va17cs54', 'Manu'),
('1va17is015', '17cs', 't203', 50, 20, '20', 'P', '17-11-2019', '1va17cs54', 'Suraj'),
('1va17is019', '17cs', 't203', 50, 20, '20', 'A', '17-11-2019', '1va17cs54', 'Harshita '),
('1va17is030', '17cs', 't203', 50, 20, '20', 'A', '17-11-2019', '1va17cs54', 'Navaratna'),
('1va17is038', '17cs', 't203', 50, 20, '20', 'A', '17-11-2019', '1va17cs54', 'Reetik chitragupt'),
('1va17is054', '17cs', 't203', 50, 20, '20', 'P', '17-11-2019', '1va17cs54', 'Shreyas'),
('1va17is004', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Aishwarya'),
('1va17is005', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Arjun R'),
('1va17is010', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Manu'),
('1va17is014', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Bhagat Singh'),
('1va17is015', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Suraj H'),
('1va17is019', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Harshita '),
('1va17is026', '17cs', 't202', 50, 20, '20', 'A', '17-11-2019', '1va17cs53', 'Anupam Mishra'),
('1va17is030', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Navaratna Hegde'),
('1va17is038', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Reetik chitragupt'),
('1va17is054', '17cs', 't202', 50, 20, '20', 'P', '17-11-2019', '1va17cs53', 'Shreyas');

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
('1VA17IS011', 'Rach', 'ISE', '1va17cs53', 0, 0, 0),
('1VA17IS032', 'LL', 'ISE', '1va17cs53', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `USN` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
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
('1VA17CS001', 'bhaskar', '2017', 'CSE', 'CSE', 't201', '1/9/99', 90909, 'bhaskar@gmail.com', '17CS', '1VA17CS001', '1va17cs001'),
('1va17cs033', 'Siddhnat', '2017', 'CSE', 'cse', 't202', '5/3/98', 799865545, 'sidd@gmail.com', '17CS', '1va17cs033', '1va17cs033'),
('1va17cs035', 'Shreyansh', '2016', 'CSE', 'cse', 't205', '10/2/99', 9444332211, 'shreyansh@gmail.com', '17CS', '1va17cs035', '1va17cs035'),
('1va17cs036', 'Rakesh', '2017', 'CSE', 'cse', 't205', '5/8/2000', 94522211444, 'rakesh@gmail.com', '17CS', '1va17cs036', '1va17cs036'),
('1va17is004', 'Aishwarya', '2017', 'ISE', 'ise', 't201', '20//5//1', 94552211345, 'reetik@gmail.com', '17CS', '1va17is004', '1va17is004'),
('1va17is008', 'ArjunC', '2017', 'ISE', 'ise', 't203', '5//6//99', 9456633211, 'arjun@gmail.com', '17CS', '1va17is008', '1va17is008'),
('1va17is010', 'Manu', '2016', 'ISE', 'ise', 't200', '4/////6/', 9974444566, 'manu@gmail.com', '17CS', '1va17is010', '1va17is010'),
('1VA17IS011', 'Rach', '2017', 'ISE', 'ISE', 't202', '55/55/656', 9564123541, 'jli', '17CS', '1VA17IS011', '1va17is011'),
('1va17is014', 'Bhagat Singh', '2017', 'ISE', 'ise', 't202', '5/6/98', 987455662, 'bhagat@gmail.com', '17CS', '1va17is014', '1va17is014'),
('1va17is015', 'Suraj H', '2017', 'ISE', 'ise', 't200', '12/3/9', 9450022211, 'suraj@gmail.com', '17CS', '1va17is015', '1va17is015'),
('1VA17IS018', 'Rachana', '2017', 'ISE', 'ISE', 't202', '5/6/99', 7996666555, 'rachana@gmail.com', '17CS', '1VA17IS018', '1va17is018'),
('1va17is019', 'Harshita ', '2017', 'ISE', 'ise', 't201', '22/5/99', 9444555788, 'harshita@gmail.com', '17CS', '1va17is019', '1va17is019'),
('1va17is026', 'Anupam Mishra', '2017', 'ISE', 'ise', 't202', '25/9/99', 7355669944, 'anupam@gmail.com', '17CS', '1va17is026', '1va17is026'),
('1va17is030', 'Navaratna Hegde', '2017', 'ISE', 'ise', 't203', '9/9/20', 7355670645, 'nav@gmail.com', '17CS', '1va17is030', '1va17is030'),
('1va17is038', 'Reetik Chitragupt', '2017', 'ISE', 'ise', 't200', '7///////', 7355670645, 'reetik@gmail.com', '17CS', '1va17is038', '1va17is038'),
('iva16cv012', 'Himesh Acharya', '2016', 'CIVIL', 'civil', 't204', '25/6/99', 9466332211, 'himesh@gmail.com', '17CIV', 'iva16cv012', 'iva16cv012');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `sb1` varchar(10) NOT NULL,
  `sb2` varchar(10) NOT NULL,
  `sb3` varchar(10) NOT NULL,
  `sb4` varchar(10) NOT NULL,
  `sb5` varchar(10) NOT NULL,
  `class_id` varchar(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Teacher_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`sb1`, `sb2`, `sb3`, `sb4`, `sb5`, `class_id`, `Name`, `Teacher_id`) VALUES
('1va17cs50', '1va17cs51', '1va17cs52', '1va17cs53', '1va17cs54', 'cse1', 'cse/ise subjects', 'T100'),
('1va17ME50', '1va17ME51', '1va17ME52', '1va17ME53', '1va17ME54', 'mech1', 'mechanical subjects', 'HODM');

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
('t200', 'Prof. Mamtha', 'ISE', 'cse1', '0000-00-00', '46531654', 'mam@gmail.com', '2011-05-05', 'Teacher', '1va17cs50', 't200'),
('t201', 'Prof. Deeksha Hegde', 'CSE', 'cse1', '2019-11-01', '46531654', 'something@gmail.com', '2011-05-05', 'Teacher', '1va17cs51', 't201'),
('t202', 'Prof.VrindaShetty', 'ISE', 'cse', '2019-11-02', '46531654', 'vrinda@gmail.com', '2011-05-05', 'HOD', '1va17cs53', 't202'),
('t203', 'Prof. Neelambika ', 'ISE', 'cse1', '2005-02-22', '99455522', 'neelambika@gmail.com', '2011-05-05', 'Teacher', '1va17cs54', 't203'),
('t204', 'Akshay Kumar', 'CIVIL', 'civil', '6/9/90', '9996663332', 'akshay@gmail.com', '2014', 'Teacher', '17CIV50', 't204'),
('t205', 'Prof Santosh', 'CSE', 'cse', '9/3/2017', '9455661233', 'santosh@gmail.com', '2019', 'Teacher', '17cs50', 't205');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
 ADD KEY `Subject_id` (`Subject_id`);

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
 ADD KEY `Teacher_id` (`Teacher_id`);

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
