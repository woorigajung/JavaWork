-- view v_ 로 시작
-- OR REPLACE 써도 되고 안써도되는데
-- 뜻은 기존에 있었으면 지우고 다시만드세요 라는 뜻
CREATE OR REPLACE VIEW v_prof
AS
SELECT profno, name, email, hpage 
FROM T_PROFESSOR;

SELECT * FROM v_prof;
SELECT tname FROM tab;

-- 뷰 삭제
DROP VIEW v_prof;

-- View 생성시 별도의 컬럼이름을 지정해 줄 수 있다.
CREATE OR REPLACE VIEW v_prof(pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage 
FROM T_PROFESSOR
;
SELECT nm FROM v_prof;

-- #8102)
-- t_professor, t_department 테이블을 join 하여
-- 교수번호와 교수이름과 소속학과 이름을 조회하는 view 를 생성하세요.  
-- (이름: v_prof_dept)
CREATE OR REPLACE VIEW v_prof_dept("교수번호","교수이름","소속학과명")
AS 
SELECT p.PROFNO , p.NAME , d.DNAME
FROM T_PROFESSOR p,T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO;
-- 확인
SELECT * FROM v_prof_dept;


-- #8103)
-- t_student, t_department 테이블 :
-- 학과별로 학생들의 최대키와 최대몸무게, 학과 이름을 출력하세요
SELECT 
	d.dname "학과명", 
	s.max_height "최대키", 
	s.max_weight "최대몸무게"
FROM 
	( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
	FROM t_student
	GROUP BY deptno1 ) s , 
	t_department d
WHERE 
	s.deptno1 = d.deptno;


-- #8104)
-- t_student, t_department 테이블 :
-- 학과별(deptno1)로 가장 키가 큰 학생들의
-- 이름과 키, 학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요
SELECT d.dname "학과명", a.max_height "최대키", s.name "학생이름", s.height "키"
FROM 
	(SELECT deptno1, MAX(height) max_height FROM t_student GROUP BY deptno1) a,
	t_student s, t_department d
WHERE 
	s.deptno1 = a.deptno1 AND s.height = a.max_height
	AND s.deptno1 =  d.deptno
;

--#8105) 연습
--t_student 테이블 : 
--학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, 
--inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.
SELECT GRADE , AVG(HEIGHT) 
FROM T_STUDENT 
GROUP BY grade;

SELECT s.GRADE 학년, s.NAME 이름, s.HEIGHT 키, a.avg_height 평균키
FROM 
	(SELECT GRADE , AVG(HEIGHT) avg_height FROM T_STUDENT GROUP BY grade) a,
t_student s
WHERE a.grade = s.GRADE AND s.HEIGHT > a.avg_height
ORDER BY 1;
