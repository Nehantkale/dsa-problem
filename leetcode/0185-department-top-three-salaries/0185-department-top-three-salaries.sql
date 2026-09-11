select d.name as department,
e.name as employee,
e.salary as salary from (
    select *, DENSE_RANK() over(
        partition by departmentId
       ORDER BY salary DESC
    ) as salary_rank from employee) e join department d on e.departmentid=d.id where e.salary_rank<=3;
