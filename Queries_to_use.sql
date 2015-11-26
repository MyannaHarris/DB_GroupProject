select Company.name, Department.dept_name, Position.title, Position.accepted_major, Position.accepted_gpa
from Company natural join Department natural join Position
order by Company.name;

select Company.name, Department.dept_name
from Company natural join Department
order by Company.name;

select Student.first_name, Student.last_name
from Student
where class = "Sophomore";
