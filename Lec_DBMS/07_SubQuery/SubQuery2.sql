-- 다중칼럼 Sub Query
-- Sub Query 결과가 여러 칼럼인 경우.  
-- 주로 Primary Key 를 여러 칼럼을 합쳐서 만들었을 경우 
-- 한꺼번에 비교하기 위해서 자주 사용.

-- #7201)
-- t_student 테이블을 조회하여 각 학년별로
-- 최대 키를 가진 학생들의 학년과 이름과 키를 출력하세요,  학년 오름차순으로 출력

SELECT grade, MAX(HEIGHT)
FROM T_STUDENT GROUP BY GRADE;

SELECT GRADE 학년, NAME 이름, HEIGHT 키
FROM T_STUDENT 
WHERE (GRADE, HEIGHT) IN (SELECT grade, MAX(HEIGHT)
FROM T_STUDENT GROUP BY GRADE)
ORDER BY GRADE ASC;

-- #7202)
-- t_professor , t_department 테이블 :  각 학과별로
-- 입사일이 가장 오래된 교수의 교수번호와 이름, 학과명을 출력하세요.
--  단 학과이름 순으로 오름차순 정렬하세요
SELECT DEPTNO ,TO_CHAR(MIN(HIREDATE),'rrrr-mm-dd') FROM T_PROFESSOR GROUP BY DEPTNO;
SELECT  p.PROFNO ,p.NAME , d.DNAME 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO 
AND 
(d.DEPTNO , p.HIREDATE) IN (SELECT DEPTNO, MIN(HIREDATE) FROM T_PROFESSOR GROUP BY DEPTNO)
ORDER BY d.DNAME aSC;


-- #7203)
-- t_emp2 테이블 : 직급별로 해당직급에서 최대 연봉을 받는 직원의
-- 이름과 직급, 연봉을 출력하세요,
-- 단, 연봉순으로 오름차순 정렬하세요
SELECT  * FROM T_EMP2;
SELECT post, MAX(PAY) FROM T_EMP2 GROUP BY POST;
SELECT NAME 이름, PAY 연봉
FROM T_EMP2
WHERE (POST,PAY) IN (SELECT POST, MAX(PAY) FROM T_EMP2 GROUP BY POST)
ORDER BY 연봉 ASC;

-- #7204)
-- t_emp2, t_dept2 테이블 : 각 부서별 평균 연봉을 구하고 
-- 그 중에서 평균 연봉이 가장 적은 부서의 평균연봉보다 적게 받는 직원들의
-- 부서명, 직원명, 연봉을 출력 하세요
SELECT AVG(PAY) FROM T_EMP2 GROUP BY DEPTNO;
SELECT d.DNAME 부서명, e.NAME 직원명, e.PAY 연봉
FROM T_EMP2 e, T_DEPT2 d
WHERE e.DEPTNO = d.DCODE AND 
PAY < (SELECT MIN(AVG(PAY)) FROM T_EMP2 GROUP BY DEPTNO)
ORDER BY 연봉 ASC, 직원명 ASC;

-- 상호연관 Sub Query
-- Main Query 값을 Sub Query 에 주고
-- Sub Query를 수행한 후 그 결과를 다시 Main Query 로 반환해서 수행하는 쿼리.

-- #7205)
-- t_emp2 테이블 : 직원들 중에서 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의
-- 이름과 직급, 현재 연봉을 출력하세요.

SELECT a.NAME 사원이름, NVL(a.POST,' ') 직급, a.PAY 급여
FROM T_EMP2 a
--WHERE a.PAY >= (a.POST 직급의 평균 연봉 )
WHERE a.PAY  >= (SELECT AVG(b.pay) FROM T_EMP2 b WHERE NVL(a.POST,' ') = NVL(b.POST, ' '));
;

SELECT AVG(b.pay) FROM T_EMP2 b WHERE '과장' = b.POST ;


-- 참고: Sub Query 위치별 이름
-- Sub Query 는 오는 위치에 따라서 그 이름이 다릅니다
-- SELECT ( Sub Query )  ← 1행만 반환할 경우,  Scala Sub Query (스칼라 서브쿼리)
-- FROM ( Sub Query )  ← Inline View (인라인 뷰)
-- WHERE ( Sub Query ) ← Sub Query 라고 부릅니다

-- #7206)
-- t_emp2, t_dept2 테이블: 조회하여 사원들의 이름과 부서 이름을 출력
-- 스칼라 서브쿼리 방식
SELECT 
name "사원이름", 
(SELECT d.dname FROM t_dept2 d
	WHERE e.deptno = d.dcode) "부서이름"
FROM t_emp2 e;
