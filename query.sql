select empno ,ename,sal from emp ;
select empno ,ename,sal from emp where deptno = 99;
SELECT * FROM EMP;
select * FROM hist_sal;

select ename,hist_sal.sal from hist_sal join emp on hist_sal.empno = emp.empno;


select empno, ename,sal from emp where deptno=90;

SELECT * FROM HIST_SAL WHERE empno = 9001 ORDER BY todate DESC;