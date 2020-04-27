-- dual 은  ROW 1개 짜리 dummy TABLE;
SELECT  'abcd' FROM  dual;
-- SQL println 이라 보면됨
SELECT  '안녕하세요' FROM dual;
SELECT  100 FROM  dual;
SELECT  100 + 10 FROM  dual;


-- * 모든 컬럼
SELECT * FROM  T_EMP;


-- 원하는 컬럼만 조회
SELECT EMPNO ,ENAME 
FROM T_EMP;

SELECT EMPNO ,ENAME 
FROM T_EMP WHERE EMPNO >7600;


--
SELECT *FROM T_PROFESSOR;
SELECT BONUS FROM T_PROFESSOR; 


-- 꼭 포함된 값이 아니어도 된다
-- 뽑아낼 때 마다 안녕하세요 출력한 것(16개 값이 있어서 16개 안 출력)
SELECT '안녕하세요' FROM T_PROFESSOR ;


-- table로 부터 select하지만 결과도 select이다
SELECT name, '교수님 사랑해요' FROM T_PROFESSOR;


-- 컬럼 별명(alias) 사용한 출력
-- collumn 명 띄고 별명 
SELECT STUDNO 학번, NAME 이름 
FROM T_STUDENT;
-- 별명을 띄어 쓰고 싶을 때
SELECT studno "학번" , NAME  AS 이름
FROM T_STUDENT;
SELECT STUDNO "학번 학번" , NAME 이름 
FROM T_STUDENT;
-- 연습
SELECT  empno 사원번호, ENAME 사원명, JOB 직업
FROM T_EMP; 
SELECT DEPTNO  부서#, DNAME 부서명, LOC  위치
FROM T_DEPT ;


-- DISTINCT
SELECT * FROM T_EMP ;
SELECT DEPTNO FROM T_EMP ;
SELECT DISTINCT deptno FROM T_EMP ;
-- 연습
SELECT DISTINCT DEPTNO1 FROM T_STUDENT ;
SELECT DISTINCT job FROM  T_EMP ;


-- || : 필드, 문자열 연결 연산
SELECT name, POSITION 
FROM T_PROFESSOR 

SELECT name || ' ' || POSITION  교수님명단
FROM T_PROFESSOR ;

SELECT * FROM T_PROFESSOR ;
SELECT * FROM T_STUDENT ;


-- 연습
SELECT '서진수의 키는 ' || HEIGHT || 'cm, 몸무게는 ' || WEIGHT || 'kg 입니다.'
"학생의 키와 몸무게"
FROM T_STUDENT ;
