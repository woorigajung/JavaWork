-- #7101) 
-- t_emp 테이블에서 scott 보다 
-- 급여를 많이 받는 사람의 이름과 급여 출력
SELECT * FROM T_EMP;

SELECT ENAME , SAL 
FROM  T_EMP 
WHERE sal > (SELECT sal FROM T_EMP WHERE ENAME = 'SCOTT');


SELECT sal FROM T_EMP WHERE ENAME = 'SCOTT';


-- #7102) 
-- t_student 테이블에서 가장 키 큰 학생의 
-- '이름'과 '키'를 출력
SELECT MAX(HEIGHT) FROM T_STUDENT ;

SELECT NAME , HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT) ;


-- 1. SubQuery 는 연산자 오른쪽에 위치해야 하며 반드시 괄호로 묶어야 한다
-- 2. 특별한 경우를 제외하고는 SubQuery절에는 Order By 가 올수 없습니다
-- 3. 단일행SubQuery , 다중행SubQuery 에 따라 연산자를 잘 선택해야 한다

-- 단일행 서브 커리
-- 결과가 한개 1행만 나오는 것.
-- 단일행 Sub Query 의  WHERE 에서 사용되는 연산자
--  = , !=, <> , >, >= , <, <= 

-- #7103)
-- t_student, t_department 테이블 사용하여
-- 이윤나 학생과 1전공이 동일한 학생들의 이름과 1전공 이름을 출력하세요
SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나';

SELECT s.name "학생이름", d.dname "1전공"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno AND s.deptno1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나');

-- #7104) 연습
--t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 
--이름과 입사일, 학과명을 출력하세요
SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권';
SELECT  p.NAME ,d.DNAME 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO AND 
p.HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권');

-- #7105) 연습
--t_student 테이블 :  1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 
--이름과 몸무게를 출력하세요
SELECT avg(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = 101;
SELECT NAME, WEIGHT
FROM T_STUDENT
WHERE WEIGHT > (SELECT avg(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = 101);

--#7106) 연습
--t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 
--조인형 교수보다 월급을 적게 받는 교수의  이름과 급여, 입사일을 출력하세요
SELECT PAY FROM T_PROFESSOR WHERE NAME = '조인형';
SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨';
SELECT name "이름", pay "급여", hiredate "입사일"
FROM t_professor
WHERE hiredate = (SELECT hiredate FROM t_professor WHERE name = '심슨')
		AND `
	pay < (SELECT pay FROM t_professor WHERE name = '조인형');



-- 다중행 쿼리
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--		 IN 같은 값을 찾음
--		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)
--		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은)
--		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)
--		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰)
--		EXIST Sub Query 값이 있을 경우 반환

-- #7107) 
-- t_emp2, t_dept2 테이블 : 근무지역 (t_dept2.area) 이 서울 지사인 
-- 모든 사원들의 사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요
SELECT * FROM T_EMP2;
SELECT * FROM T_DEPT2;
SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사';

SELECT EMPNO , NAME , DEPTNO 
FROM T_EMP2
WHERE DEPTNO IN (SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사');

-- #7108)
-- t_emp2 테이블 : 전체직원중 과장 직급의 최소연봉자보다 연봉이 높은 사람의
-- 이름(name)과 직급(post), 연봉(pay)을 출력하세요.
-- 단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요
SELECT PAY FROM T_EMP2 WHERE POST = '과장';

SELECT NAME 이름, POST 직급, TO_CHAR(PAY, '999,999,999,999') || '원' "연봉"
FROM T_EMP2 
WHERE PAY > ANY (SELECT PAY FROM T_EMP2 WHERE POST = '과장');

-- #7109)
-- t_student 테이블 : 전체학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다
-- 몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요
SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4;
SELECT NAME 이름, GRADE 학년, WEIGHT 몸무게
FROM T_STUDENT 
WHERE WEIGHT <ALL (SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4);






