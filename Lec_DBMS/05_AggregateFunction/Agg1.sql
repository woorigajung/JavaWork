SELECT * FROM T_PROFESSOR;
SELECT COUNT(*),COUNT(HPAGE) FROM T_PROFESSOR; -- 그룹함수에서는 NULL 값은 계산에서 제외
SELECT COUNT(bonus), sum(bonus), avg(BONUS) FROM T_PROFESSOR;
SELECT MAX(HIREDATE), min(HIREDATE) FROM T_EMP;

-- null 허용 컬럼의 그룹함수 적용시
-- nvl, nvl2 사용해야 함
SELECT AVG(BONUS), avg(NVL(BONUS,0))
FROM T_PROFESSOR;


-- t_professor 테이블에서 '학과별'로 교슈들의 평균 보너스를 출력하세요
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
-- 불가능하다!, SELECT 절에 group 함수와 group 함수가 아닌 것과는 같이 출력 불가
-- SELECT DEPTNO , AVG(BONUS) 
-- FROM T_PROFESSOR 
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
SELECT DEPTNO , ROUND(AVG(NVL(BONUS,0)),1) 보너스평균 
FROM T_PROFESSOR 
GROUP BY DEPTNO;

-- #5101) t_professor 테이블 : 학과별(deptno) 
-- 그리고 직급별(position)로 교수들의 평균 급여를 계산하여 출력하세요
SELECT DEPTNO , POSITION, AVG(PAY) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO, POSITION	-- 1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ASC, POSITION DESC; 

-- 부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 학과만 출력
SELECT  DEPTNO , ROUND(AVG(PAY),1) 평균급여 
FROM T_PROFESSOR 
HAVING AVG(PAY) > 300
GROUP BY DEPTNO
;
-- WHERE AVG(PAY) > 450 -- 그룹함수는 WHERE 절에서 사용 불가

-- <SELECT 쿼리문 순서> 
-- SELECT
-- FROM
-- WHERE
-- GOUP BY, HAVING
-- ORDER BY


-- #5102) 
-- t_emp 테이블: 매니저별(MGR)로 관리하는 직원들의 
-- ‘매니저’, ‘직원수’와 ‘급여총액’과 ‘급여평균’과 ‘교통비 (COMM) 
-- 평균’ 지급액 을 출력하세요.  단 사장님은 (job = president)제외
SELECT * FROM T_EMP;
SELECT mgr 매니저, count(*) 직원수, sum(sal) 급여총액, trunc(avg(sal)) 급여평균,
		avg(nvl(comm, 0))  교통비평균
FROM t_emp
WHERE job <> 'PRESIDENT'
GROUP BY mgr
;
-- #5103) 
-- t_professor 테이블 :  직위가 정교수 혹은 조교수 인 분들 중에서 
-- ‘과별(deptno)’로  과번호, 소속교수 총수, 근속일 평균, 급여평균, 
-- 보너스 평균을 출력해보세요
SELECT  * FROM T_PROFESSOR; 
SELECT DEPTNO, COUNT(*) 소속교수총수,
ROUND(AVG(SYSDATE - HIREDATE),1) 근속평균, 
round(avg(PAY),1) 급여평균,
ROUND(AVG(NVL(BONUS,0)),1) 보너스평균
FROM T_PROFESSOR
WHERE POSITION LIKE '%교수'
GROUP BY DEPTNO
--,AVG(TO_CHAR(SYSDATE, 'yyyy-mm-dd') - TO_CHAR(HIREDATE, 'yyyy-mm-dd')

-- #5104) 
-- t_student 테이블 : 학과별(deptno1) 로,
-- 학과번호, 최대몸무게 - 최소몸무게 차이 값을 출력해보세요
SELECT * FROM T_STUDENT;
SELECT DEPTNO1, MAX(WEIGHT)-MIN(WEIGHT) 
FROM T_STUDENT
GROUP BY DEPTNO1;

-- #5105) 
-- 그 차이가 30 이상인것만 출력하려면?
SELECT * FROM T_STUDENT;
SELECT DEPTNO1, MAX(WEIGHT)-MIN(WEIGHT) 
FROM T_STUDENT
GROUP BY DEPTNO1
HAVING MAX(WEIGHT)-MIN(WEIGHT) >= 30;