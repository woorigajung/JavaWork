-- JOIN

-- FROM 절에 테이블에도 별칭(alias)를 줄수 있다!
-- 20 레코드
SELECT s.studno, s.name, s.deptno1
FROM t_student s;

-- 12 레코드
SELECT d.DEPTNO , d.dname
FROM t_department d


-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 


-- 240개
SELECT s.studno, s.name, s.deptno1,
	d.deptno, d.dname
FROM t_student s, t_department d  -- Oracle 방식
;

SELECT s.studno, s.name, s.deptno1,
	d.deptno, d.dname
FROM t_student s 
	CROSS JOIN t_department d -- ANSI 방식
;
-- ＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆＆
-- Equi Join (등가 Join)

-- #6101
-- Oracle Join 방식
SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s, t_department d
WHERE s.deptno1 = d.deptno    -- 조건 (Equi JOIN)
;

-- ANSI 방식
SELECT s.name "학생이름", s.deptno1 "학과번호", d.dname "학과이름"
FROM t_student s JOIN t_department d ON s.deptno1 = d.deptno    -- 조건 (Equi JOIN)
;

SELECT * FROM t_student;

-- 제2전공은?  deptno2
SELECT s.name "학생이름", s.deptno2 "제2학과", d.dname "제2학과이름"
FROM t_student s, t_department d
WHERE s.deptno2 = d.deptno
;

-- #6102
-- t_student 테이블, t_professor 테이블 을 join하여
-- ‘학생이름’, ‘지도교수 번호’, ‘지도교수이름’ 을 출력하세요
SELECT * FROM T_STUDENT;
SELECT * FROM T_PROFESSOR ;
SELECT s.NAME ,p.PROFNO ,p.NAME 
FROM T_STUDENT s, T_PROFESSOR p 
WHERE s.PROFNO = p.PROFNO 

SELECT s.NAME ,p.PROFNO ,p.NAME 
FROM T_STUDENT s join T_PROFESSOR p
ON s.PROFNO = p.PROFNO

-- #6103
-- t_student, t_department, t_professor 테이블 을 join 하여  
-- 학생의 이름, 학과이름, 지도교수 이름  을 출력하세요
SELECT * FROM T_STUDENT;
SELECT * FROM T_DEPARTMENT;
SELECT * FROM T_PROFESSOR ;

SELECT s.NAME 학생이름,d.DNAME 학과이름 ,p.NAME 교수이름
FROM T_STUDENT s 
join T_DEPARTMENT d ON s.DEPTNO1 =d.DEPTNO
join T_PROFESSOR p on s.PROFNO = p.PROFNO

-- #6104
-- t_emp2 직원 테이블과 t_post 직급 테이블을 조회하여 
-- 사원의 이름과 직급, 현재연봉, 
-- 해당직급의 연봉의 하한금액(s_pay)과 상한금액(e_pay)을 출력하세요
SELECT * FROM T_EMP2;
SELECT * FROM T_POST;
SELECT e2.NAME, e2.POST, e2.PAY,
p.S_PAY ,p.E_PAY 
FROM T_EMP2 e2, T_POST p
WHERE e2.POST = p.POST; 

SELECT e2.NAME, e2.POST, e2.PAY,
p.S_PAY ,p.E_PAY 
FROM T_EMP2 e2 join T_POST p
on e2.POST = p.POST ;

-- #6105) 
-- t_student - t_professor 테이블 join 하여 제1전공(deptno1) 이
-- 101번인 학생들의 학생이름과 지도교수 이름을 출력하세요
SELECT * FROM T_STUDENT;
SELECT * FROM T_PROFESSOR;
SELECT s.NAME,p.NAME 
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO -- join 조건
AND s.DEPTNO1 = 101; -- 검색조건

SELECT s.NAME,p.NAME 
FROM T_STUDENT s join T_PROFESSOR p 
on s.DEPTNO1 = 101 AND s.PROFNO = p.PROFNO; -- s.deptn01은 where문으로가도된다








