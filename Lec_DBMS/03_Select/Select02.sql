-- 산술연산자

SELECT ENAME , sal * 1.1
FROM T_EMP;

SELECT ENAME , SAL , COMM 
FROM T_EMP ;


-- NULL 값과의 산순연산은 무.조.건 NULL!
SELECT ENAME , SAL , COMM , SAL +COMM 
FROM T_EMP ;

SELECT * FROM  T_EMP WHERE JOB = 'SALESMAN'; -- 문자열은 대소문자 구분!


-- p13
-- 직원 테이블(t_emp) 에서 10번 부서(deptno)에 근무하는 직원의 
-- 이름(ename)과 급여(sal)와 부서번호(deptno) 출력
SELECT ename, sal, deptno
FROM T_EMP 
WHERE DEPTNO = 10;
-- 직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 
-- 이름(ename)과 급여(sal)를 출력하세요
SELECT ENAME , SAL 
FROM  T_EMP 
WHERE sal >2000;
-- 직원 테이블(t_emp) 에서 이름이 SCOTT인 사람의 
-- 이름(ename)과 사원번호(empno), 급여(sal) 출력
SELECT ENAME , EMPNO , SAL 
FROM T_EMP 
WHERE ENAME = 'SCOTT'


-- 연습
-- 학생 테이블(t_student)에서
-- 2,3 학년(grade) 학생의 이름(name), 학년(grade)출력

SELECT * FROM  T_STUDENT ;
SELECT name, GRADE FROM T_STUDENT WHERE grade = 2 OR  grade = 3;
SELECT name, GRADE FROM T_STUDENT WHERE grade IN (2,3);
SELECT name, GRADE FROM T_STUDENT WHERE grade > 1 AND GRADE < 4;
SELECT name, GRADE FROM T_STUDENT WHERE grade NOT IN (2,3);
SELECT name, GRADE FROM T_STUDENT WHERE grade BETWEEN 2 AND 3;

-- 교수님 (t_professor) 중에서
-- 급여 (pay) 가 300 보다 크고,
-- 직급 (position) 이 '정교수' 인 분들의
-- 이름(name), 급여(pay), 직급(position) 을 출력하세요
SELECT * FROM T_PROFESSOR ;
SELECT NAME 이름, PAY 급여, POSITION 직급
FROM T_PROFESSOR 
WHERE PAY > 300 AND POSITION = '정교수';

-- 보너스(bonus)를 못받고 있는 
-- 교수님의 이름(name)과 직급(position)를 출력하세요
SELECT name 교수, POSITION 직급
FROM T_PROFESSOR 
WHERE BONUS IS NULL ;

-- 교수님 중에서 김씨 성을 가진 교수님의 이름만 출력 (LIKE 사용)
SELECT NAME 
FROM T_PROFESSOR
WHERE NAME LIKE '김%';

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- NE 문자열이 포함된 직원만 출력
SELECT ename FROM T_EMP WHERE ENAME LIKE '%NE%';

-- 직원 테이블(t_emp)에서 직원이름 (ename) 중에
-- 두번째 글자가 'A' 인 사람의 이름(ename)만 출력
SELECT  ename FROM  T_EMP WHERE ENAME LIKE '_A%';

------------------------------
-- ORDER BY
-- 직원중 이름에 L이 들어간 사람의 이름을 사전내림차순으로 출력하기
SELECT ENAME FROM T_EMP WHERE ENAME LIKE '%L%'
ORDER BY ENAME DESC ;

-- 직원의 이름, 직책, 급여를 출력하되
-- 우선은 직책(job) 사전 내림차순으로,
-- 그리고 급여(sal) 오름차순으로 출력
SELECT ENAME , JOB , SAL 
FROM T_EMP
ORDER BY JOB DESC, SAL  ASC ;

-- 학생 테이블(t_student) 에서  학생의 이름(name)과 
-- 학년(grade)와 키(height)를 출력하세요, 
-- 단 학년은 1학년부터 출력하고,  키는 큰사람부터  출력하세요
SELECT NAME 이름, GRADE 학년, HEIGHT 키
FROM T_STUDENT ORDER BY GRADE ASC , HEIGHT DESC; 

CREATE TABLE jjh (
name varchar2(12) NOT NULL
);

