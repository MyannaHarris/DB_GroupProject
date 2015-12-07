DROP view  if exists applicationTracking_DB.company_positions;
DROP view  if exists applicationTracking_DB.Alumni_applied;
DROP view  if exists applicationTracking_DB.Student_applied;
DROP view  if exists applicationTracking_DB.company_and_departments;
DROP view  if exists applicationTracking_DB.User_position;
DROP view  if exists applicationTracking_DB.User_Student_Application;
DROP view  if exists applicationTracking_DB.User_Alumni_Application;
DROP view  if exists applicationTracking_DB.User_Student_Applicant;
DROP view  if exists applicationTracking_DB.User_Alumni_Applicant;

DROP TABLE IF EXISTS applicationTracking_DB.Application;
DROP TABLE IF EXISTS applicationTracking_DB.Applicant;
DROP TABLE IF EXISTS applicationTracking_DB.Student;
DROP TABLE IF EXISTS applicationTracking_DB.Alumni;
DROP TABLE IF EXISTS applicationTracking_DB.Position;
DROP TABLE IF EXISTS applicationTracking_DB.Department;
DROP TABLE IF EXISTS applicationTracking_DB.Company;



CREATE TABLE `applicationTracking_DB`.`Student` (
  `applicant_id` INT NOT NULL ,
  `first_name` VARCHAR(45) NOT NULL ,
  `last_name` VARCHAR(45) NOT NULL ,
  `class` VARCHAR(45) NOT NULL ,
  `expected_grad_date` DATE NOT NULL ,
  `MSC` INT NOT NULL,
  `student_number` INT NOT NULL,
  `username_student` VARCHAR(45) NOT NULL ,
  `password_student` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`applicant_id`), 
  check(applicant_id > 0));
  
INSERT INTO `applicationTracking_DB`.`Student` (`applicant_id`, `first_name`, `last_name`, `class`, `expected_grad_date`, `MSC`, `student_number`, `username_student`, `password_student`) VALUES ('123958', 'James', 'Jones', 'Sophomore', '2018-05-09', '3124', '12345167', 'jjones58', 'password1');
INSERT INTO `applicationTracking_DB`.`Student` (`applicant_id`, `first_name`, `last_name`, `class`, `expected_grad_date`, `MSC`, `student_number`, `username_student`, `password_student`) VALUES ('698305', 'Thomas', 'Gill', 'Freshman', '2019-05-06', '3331', '32905157','tgill05', 'gill1234');
INSERT INTO `applicationTracking_DB`.`Student` (`applicant_id`, `first_name`, `last_name`, `class`, `expected_grad_date`, `MSC`, `student_number`, `username_student`, `password_student`) VALUES ('900123', 'Melissa', 'Warner', 'Sophomore', '2018-05-09', '1267', '90053141', 'mwarner23', 'pumpkinsp1ce');
INSERT INTO `applicationTracking_DB`.`Student` (`applicant_id`, `first_name`, `last_name`, `class`, `expected_grad_date`, `MSC`, `student_number`, `username_student`, `password_student`) VALUES ('800346', 'Craig', 'Jasper', 'Junior', '2017-05-10', '2782', '71256911', 'cjasper46', 'ghost831');
INSERT INTO `applicationTracking_DB`.`Student` (`applicant_id`, `first_name`, `last_name`, `class`, `expected_grad_date`, `MSC`, `student_number`, `username_student`, `password_student`) VALUES ('445223', 'Katelyn', 'Jenner', 'Senior', '2016-05-09', '2212', '66677889', 'kjenner23', 'p1neapple');

CREATE TABLE `applicationTracking_DB`.`Alumni` (
  `applicant_id` INT NOT NULL ,
  `first_name` VARCHAR(45) NOT NULL ,
  `last_name` VARCHAR(45) NOT NULL ,
  `graduation_date` DATE NOT NULL ,
  `age` INT NOT NULL ,
  `current_job` VARCHAR(45) NOT NULL ,
  `username_alumni` VARCHAR(45) NOT NULL ,
  `password_alumni` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`applicant_id`),
  check(applicant_id > 0));
  
INSERT INTO `applicationTracking_DB`.`Alumni` (`applicant_id`, `first_name`, `last_name`, `graduation_date`, `age`, `current_job`,`username_alumni`, `password_alumni`) VALUES ('813425', 'Greg', 'Skywalker', '2015-05-10', '22', 'unemployed', 'gskywalker25', 'daF0rce');
INSERT INTO `applicationTracking_DB`.`Alumni` (`applicant_id`, `first_name`, `last_name`, `graduation_date`, `age`, `current_job`,`username_alumni`, `password_alumni`) VALUES ('215921', 'Justin', 'Mangis', '1999-05-07', '36', 'programmer', 'jmangis21', 'oilman23');
INSERT INTO `applicationTracking_DB`.`Alumni` (`applicant_id`, `first_name`, `last_name`, `graduation_date`, `age`, `current_job`,`username_alumni`, `password_alumni`) VALUES ('299530', 'Phil', 'Prescott', '2007-05-06', '30', 'teacher', 'pprescott30', 'likem1ke');
INSERT INTO `applicationTracking_DB`.`Alumni` (`applicant_id`, `first_name`, `last_name`, `graduation_date`, `age`, `current_job`,`username_alumni`, `password_alumni`) VALUES ('989900', 'Jill', 'Valentine', '2013-12-18', '24', 'unemployed', 'jjvalentine00', 'plaga5');
INSERT INTO `applicationTracking_DB`.`Alumni` (`applicant_id`, `first_name`, `last_name`, `graduation_date`, `age`, `current_job`,`username_alumni`, `password_alumni`) VALUES ('558372', 'Grace', 'May', '2011-12-17', '27', 'unemployed', 'gmay72', 'aprilra1n');

CREATE TABLE `applicationTracking_DB`.`Applicant` (
  `applicant_id` INT NOT NULL ,
  `GPA` DECIMAL(3,2) NOT NULL ,
  `resume_on_file` TINYINT(1) NOT NULL DEFAULT '0' ,
  `cover_letter_on_file` TINYINT(1) NOT NULL DEFAULT '0' ,
  `major_1` VARCHAR(45) NOT NULL ,
  `major_2` VARCHAR(45) NULL ,
  `home_address` VARCHAR(45) NOT NULL ,
  `phone_number` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`applicant_id`) );
  
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('215921', '3.54', '1', '0', 'Computer Science', '445 Roosevelt Lane', '208-999-6789');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `major_2`, `home_address`, `phone_number`) VALUES ('299530', '2.87', '1', 'n0', 'Psychology', 'Sociology', '34 South Second St', '503-789-4568');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('558372', '2.34', '0', '1', 'Sociology', '412 North First Street', '503-896-7852');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('813425', '3.67', '1', '1', 'Nursing', '513 Candy Lane', '678-333-4569');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `major_2`, `home_address`, `phone_number`) VALUES ('989900', '3.45', '1', '1', 'Political Science', 'Music', '688 Haag Boulevard', '204-896-4789');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `major_2`, `home_address`, `phone_number`) VALUES ('123958', '3.89', '1', '1', 'Theater', 'Business', '4000 E Nora Ave', '703-564-7823');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('445223', '3.12', '0', '1', 'Mechanical Engineering', '5678 W Mission Ave', '789-566-2113');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('698305', '3.23', '1', '0', 'Biology', '1234 Sharp Ave', '776-888-9787');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `major_2`, `home_address`, `phone_number`) VALUES ('800346', '3.56', '1', '0', 'Art', 'Chemistry', '567 Opera Ave', '465-777-8989');
INSERT INTO `applicationTracking_DB`.`Applicant` (`applicant_id`, `GPA`, `resume_on_file`, `cover_letter_on_file`, `major_1`, `home_address`, `phone_number`) VALUES ('900123', '2.56', '1', '1', 'Chemistry', '12 SW Trink Ave', '445-677-8874');


CREATE TABLE `applicationTracking_DB`.`Company` (
  `company_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`company_id`)  );
  
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9001', 'Theater Cosulting Group', 'Santa Fe', 'NM');
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9002', 'Joy Division Divorce Attorneys', 'Tampa', 'FL');
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9003', 'BBQ\'s Tanning Beds', 'Omaha', 'NE');
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9004', 'Shady Business Nursery', 'Sandusky', 'OH');
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9005', 'Juan in a Million', 'Des Moines', 'NM');
INSERT INTO `applicationTracking_DB`.`Company` (`company_id`, `name`, `city`, `state`) VALUES ('9006', 'Wok and Roll', 'Olympia', 'WA');

CREATE TABLE `applicationTracking_DB`.`Department` (
  `department_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `dept_name` VARCHAR(45) NOT NULL,
  `hiring` CHAR(1) NOT NULL,
  PRIMARY KEY (`department_id`, `company_id`),
  constraint foreign key (company_id) references Company(company_id));

INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10001', '9001', 'Finance', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10002', '9006', 'Finance', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10003', '9006', 'Public Relations', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10004', '9006', 'Advertising', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10005', '9003', 'Advertising', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10006', '9004', 'Research', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10007', '9005', 'Finance', 'y');
INSERT INTO `applicationTracking_DB`.`Department` (`department_id`, `company_id`, `dept_name`, `hiring`) VALUES ('10008', '9005', 'Research', 'y');

CREATE TABLE `applicationTracking_DB`.`Position` (
  `position_id` INT NOT NULL,
  `department_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `salary` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `accepted_major` VARCHAR(45) NOT NULL,
  `accepted_gpa` DECIMAL(3,2) NOT NULL,
  `apply_by_date` DATETIME NOT NULL,
  PRIMARY KEY (`position_id`, `department_id`),
  constraint foreign key (department_id) references Department(department_id));

INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('4442090', '10001', 'Lighting', '45000', 'Creates Play\'s Lighting for actors', 'Theater', '3.5', '2015-12-01 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('6889109', '10001', 'Software Engineer', '80000', 'Develops networking software for businesses', 'Computer Science', '3.3', '2015-10-11 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('8443678', '10002', 'Teacher', '50000', 'Teaches AP Psychology', 'Psychology', '2.0', '2015-11-28 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('5673139', '10002', 'Inventor', '87000', 'Invents new pullies', 'Mechanical Engineering', '3.0', '2015-09-15 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('3113901', '10003', 'Chief of Staff', '10000', 'Directs Staff', 'Sociology', '2.1', '2015-07-19 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('5673910', '10004', 'Researcher', '55000', 'Researches Bacteria', 'Biology', '3.1', '2015-04-09 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('3456112', '10008', 'Muralist', '77000', 'Draws Murals on walls of giant skyscrapers', 'Art', '3.44', '2015-10-11 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('4555231', '10005', 'Nurse', '67000', 'Aids the Doctor in surgery', 'Nursing', '1.91', '2015-10-08 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('9756624', '10006', 'Researcher', '52000', 'Researches Cows', 'Chemistry', '2.32', '2015-08-16 00::00:00');
INSERT INTO `applicationTracking_DB`.`Position` (`position_id`, `department_id`, `title`, `salary`, `description`, `accepted_major`, `accepted_gpa`, `apply_by_date`) VALUES ('1100342', '10007', 'Pianist', '110000', 'Plays piano nightly', 'Music', '3.21', '2015-11-24 00::00:00');


CREATE TABLE `applicationTracking_DB`.`Application` (
  `application_id` INT NOT NULL,
  `applicant_id` INT NOT NULL,
  `position_id` INT NOT NULL,
  `application_date` DATETIME NOT NULL,
  `under_consideration` VARCHAR(45) NOT NULL,
  `phone_interview` VARCHAR(45) NOT NULL,
  `site_interview` VARCHAR(45) NOT NULL,
  `offer` VARCHAR(45) NOT NULL,
  `rejection` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`application_id`),
  constraint foreign key (applicant_id) references Applicant(applicant_id) );
  /*constraint foreign key (position_id) references Position(position_id));*/

INSERT INTO `applicationTracking_DB`.`Application`
(`application_id`,
`applicant_id`,
`position_id`,
`application_date`,
`under_consideration`,
`phone_interview`,
`site_interview`,
`offer`,
`rejection`)
VALUES 
('1', '123958', '4442090', '2015-12-02 16:12:15', 'yes', 'yes', 'no', 'no', 'no'),
('2', '215921', '6889109', '2015-11-05 15:12:45', 'yes', 'no', 'no', 'no', 'yes'),
('3', '299530', '8443678', '2015-09-02 22:12:23', 'no', 'no', 'no', 'no', 'yes'),
('4', '698305', '5673910', '2015-12-07 12:12:15', 'no', 'no', 'no', 'no', 'yes'),
('5', '558372', '3113901', '2015-10-22 14:08:15', 'yes', 'yes', 'yes', 'no', 'no'),
('6', '445223', '5673139', '2015-12-02 12:12:35', 'yes', 'yes', 'yes', 'yes', 'no'),
('7', '800346', '3456112', '2015-12-04 13:08:15', 'yes', 'no', 'yes', 'yes', 'no'),
('8', '813425', '4555231', '2015-06-22 22:34:15', 'yes', 'no', 'no', 'no', 'no'),
('9', '900123', '9756624', '2015-11-12 18:55:15', 'yes', 'yes', 'yes', 'no', 'yes'),
('10','989900', '1100342', '2015-12-17 20:15:23', 'yes', 'no', 'no', 'no', 'no');

create unique index Applicant_index on
Applicant(applicant_id);

create unique index Application_index on
Application(applicant_id, position_id);

create view company_positions as
select Company.name, Department.dept_name, Position.title, Position.accepted_major, Position.accepted_gpa
from Company natural join Department natural join Position
order by Company.name;

create view Alumni_applied as
select Alumni.first_name, Alumni.last_name
from Alumni
order by Alumni.last_name;

create view Student_applied as
select Student.first_name, Student.last_name
from Student
order by Student.last_name;

create view company_and_departments as
select Company.name, Department.dept_name
from Company natural join Department
order by Company.name;

create view User_position as
select Position.title, Position.salary, Position.description, Position.accepted_major, Position.accepted_gpa, Position.apply_by_date
from Position
order by Position.apply_by_date;

create view User_Student_Application as
select Student.first_name, Student.last_name, Position.title, Application.application_date, Application.under_consideration, 
Application.phone_interview, Application.site_interview, Application.offer, Application.rejection
from Student natural join Application natural join Position
order by Student.last_name;

create view User_Alumni_Application as
select Alumni.first_name, Alumni.last_name, Position.title, Application.application_date, Application.under_consideration, 
Application.phone_interview, Application.site_interview, Application.offer, Application.rejection
from Alumni natural join Application natural join Position
order by Alumni.last_name;

create view User_Student_Applicant as
Select Student.first_name, Student.last_name, Student.class, Applicant.GPA, Applicant.cover_letter_on_file,
Applicant.resume_on_file, Applicant.major_1, Applicant.major_2, Applicant.home_address
from Student natural join Applicant
order by Student.last_name;

create view User_Alumni_Applicant as
Select Alumni.first_name, Alumni.last_name, Alumni.graduation_date, Applicant.GPA, Applicant.cover_letter_on_file,
Applicant.resume_on_file, Applicant.major_1, Applicant.major_2, Applicant.home_address
from Alumni natural join Applicant
order by Alumni.last_name;

