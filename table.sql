CREATE TABLE hist_sal (
    empno INTEGER,
    todate DATE,
    sal INTEGER,
    CONSTRAINT fk_hist_sal_emp FOREIGN KEY (empno) REFERENCES emp(empno)
);

-- CREE UNE DEPARTEMENT TEST 
INSERT INTO dept (deptno,dname,loc) VALUES 
(99,'TEST DEPT','ANDRANF');

CREATE SEQUENCE seq_empno
START WITH 100
INCREMENT BY 1
NOCACHE;

INSERT INTO emp (empno, ename, job, sal, deptno)
VALUES (seq_emp.NEXTVAL, 'KING', 'PDG', 2000, 99);

INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(2, 'SEMI KING', 'Petit PDG', 1500, 99, 1);

INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(3, 'DEMI KING', 'Petit PDG', 1500, 99, 1);

-- les employes
INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(seq_emp.NEXTVAL, 'Maoly', 'MpaS LAB',200, 99, 2);
INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(seq_emp.NEXTVAL, 'Colence', 'MPF LB',100, 99, 2);
INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(seq_emp.NEXTVAL, 'Edy', 'MPT', 400, 99, 3);
INSERT INTO emp (empno, ename, job, sal, deptno,mgr)
VALUES 
(seq_emp.NEXTVAL, 'Zeze', 'MPR', 700, 99, 3);




-- augmentation du sal de king
UPDATE emp 
    SET sal = 3000
    WHERE empno = 1;
INSERT INTO hist_sal (empno,todate,sal) 
VALUES(1,SYSDATE,2000);

UPDATE emp 
    SET sal = 500
    WHERE empno = 9;
INSERT INTO hist_sal (empno,todate,sal) 
VALUES(9,SYSDATE,400);