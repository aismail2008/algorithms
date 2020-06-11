Courses: CourseID*, CourseName, TeacherID
Teachers: TeacherID*, TeacherName
Students; StudentID*, StudentName

--------------------
Implement a query to get a list of all students and how many courses each student is enrolled in.

/* Solution 1: Wrap with another query*/

SELECT StudentName, Students.StudentID, Cnt
FROM (
SELECT Students.StudentID, count(StudentCourses.CourseID) as [Cnt]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID
) T INNER JOIN Students on T.studentID = Students.StudentID
x
/* Solution 2: Add StudentName to GROUP BY clause. */

SELECT StudentName, Students.StudentID, count(StudentCourses.CourseID) as [Cnt]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID, Students.StudentName

/* Solution 3: Wrap with aggregate function. */

SELECT max(StudentName) as [StudentName], Students.StudentID,
count(StudentCourses.CourseID) as [Count]
FROM Students LEFT JOIN StudentCourses
ON Students.StudentID = StudentCourses.StudentID
GROUP BY Students.StudentID

--------------------

    Implement a query to get a list of all teachers and how many students they each teach. If a teacher teaches
    the same student in two courses, you should double count the student. Sort the list in descending order of
    the number of students a teacher teaches.


    SELECT TeacherName, isnull(StudentSize.Number, 0)
FROM Teachers LEFT JOIN
    ( SELECT TeacherID, count(StudentCourses.CourseID) AS [Number]
    FROM Courses INNER JOIN StudentCourses
    ON Courses.CourseID = StudentCourses.CourseID
    GROUP BY Courses.TeacherID ) StudentSize
ON Teachers.TeacherID = StudentSize.TeacherID
ORDER BY StudentSize.Number DESC
    ==========================================
    ==========================================

    14.1) Multiple Apartments: Write a SQL query to get a list of tenants who are renting more than one

SELECT TenantName
FROM Tenants
         INNER JOIN
     (SELECT TenantID FROM AptTenants GROUP BY TenantID HAVING count(*) > 1) C
     ON Tenants.TenantID = C.TenantID

------------------

    14.2) Open Requests: Write a SQL query to get a list of all buildings and the number of open requests
(Requests in which status equals'Open').

SELECT BuildingName, ISNULL(Count, 0) as 'Count'
FROM Buildings
    LEFT JOIN
    ( SELECT Apartments.BuildingID, count(*) as 'Count'
    FROM Requests INNER JOIN Apartments
    ON Requests.AptID = Apartments.AptID
    WHERE Requests.Status = 'Open'
    GROUP BY Apartments.BuildingID) ReqCounts
ON ReqCounts.BuildingID = Buildings.BuildingID

------------------

    14.3) Close All Requests: Building #11 is undergoing a major renovation. Implement a query to close all
    requests from apartments in this building.


    UPDATE Requests
SET Status = 'Closed'
    WHERE AptID IN (SELECT AptID FROM Apartments WHERE BuildingID = 11)


===================================
Online

select h.hacker_id, h.name
from submissions s
         inner join challenges c
                    on s.challenge_id = c.challenge_id

         inner join difficulty d
                    on c.difficulty_level = d.difficulty_level

         inner join hackers h
                    on s.hacker_id = h.hacker_id

where s.score = d.score
  and c.difficulty_level = d.difficulty_level
group by h.hacker_id, h.name
having count(s.hacker_id) > 1
order by count(s.hacker_id) desc, s.hacker_id asc

------------------
select department_name, avg(salary) avrg
from employees e , salaires s
where e.employee_id = s.employee_id
having avrg < 500

------------------
select count(*) from
    (select user_id, count(*) cnt
     from event_log
     group by user_id
     having cnt between 1000 and 2000) T

------------------
select author_name, sum(b.sold_copies) cnt
from authors a, books b
where a.book_name = b.book_name
group by author_name
order by cnt des
limit 3
























