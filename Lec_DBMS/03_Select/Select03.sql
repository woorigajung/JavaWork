-- DB03
-- p25 ~ p27 12개 SELECT 쿼리
-- 1. t_student 테이블에서 키(height)가 180 보다 크거나 같은 사람 출력
SELECT * FROM T_STUDENT  WHERE HEIGHT >=180;

-- 2. t_student 테이블에서 몸무게(weight)가 60~80 인 사람의 이름과 체중 출력
SELECT NAME 이름, WEIGHT 체중 FROM T_STUDENT WHERE WEIGHT >= 60 AND  WEIGHT  <= 80;

-- 3. t_student 테이블에서는 제1전공(deptno1) 이 101번 학과학생과 201번 학과 학생들을 모두 출력하세요 (IN 연산자 활용)
SELECT * FROM T_STUDENT WHERE DEPTNO1 IN (101,201);

-- 4. LIKE 연산자 사용:  t_student 테이블에서 성이 ‘김’ 씨인 사람 조회
SELECT * FROM  T_STUDENT  WHERE NAME LIKE '김%';

-- 5. t_student 테이블에서 4학년 학생중에 키 가 170cm 이상인 사람의 이름과 학년과 키를 조회하세요
SELECT NAME 이름, GRADE 학년, HEIGHT 키 FROM T_STUDENT WHERE GRADE = 4 AND HEIGHT >= 170;

-- 6. t_student 테이블에서 1학년이거나 또는 몸무게가 80kg 이상인 학생들의 이름과 키와 학년과 몸무게를 출력하세요
SELECT NAME 이름, HEIGHT 키, GRADE 학년, WEIGHT 몸무게 FROM T_STUDENT WHERE GRADE = 1 OR  WEIGHT >= 80;

-- 7. t_student 테이블을 사용해서 2학년 중에서 키가 180cm 보다 크면서 몸무게가 70kg 보다 큰 학생들의 이름과 학년과 키와 몸무게를 출력하세요
SELECT NAME 이름, GRADE 학년, HEIGHT 키, WEIGHT 몸무게 FROM T_STUDENT WHERE GRADE = 2 AND (HEIGHT >= 180 AND WEIGHT >= 70) ;

-- 8. t_student 테이블: 2학년 학생중에서 키가 180cm보다 크거나 또는 몸무게가 70kg 보다 큰 학생들의 이름과 학년과 키와 몸무게를 출력하세요
SELECT NAME 이름, GRADE 학년, HEIGHT 키, WEIGHT 몸무게 FROM T_STUDENT WHERE GRADE = 2 AND (HEIGHT >= 180 OR WEIGHT >= 70);

-- 9. t_emp 테이블에서 고용일(hiredate)가 1992년 이전인 사람들의 이름(ename) 과 고용일을 출력하세요
SELECT ENAME 이름, HIREDATE 고용일 FROM T_EMP WHERE HIREDATE  < '1992-01-01' ;


-- 10.  t_student 테이블: 1학년 학생의 이름과 생일과 키와 몸무게를 출력하세요, 단 생일이 빠른 사람 순서대로 정렬하세요.
SELECT NAME 이름, BIRTHDAY 생일, HEIGHT 키, WEIGHT 몸무게 FROM T_STUDENT WHERE GRADE = 1 ORDER BY BIRTHDAY ASC ;


-- 11.  t_student 테이블: 1학년 학생의 이름과 키를 출력하세요, 별명은 ‘이름’, ‘키’ 로 출력.  단 이름은 오름차순으로 정렬하세요
SELECT NAME 이름, HEIGHT 키 FROM T_STUDENT WHERE GRADE = 1 ORDER BY NAME ASC ;


-- 12.  t_emp2 직원 테이블에서 생일(birthday) 이 1980년대생인 사람들의 이름과 생일만 출력하세요- 즉 (1980/01/01 ~ 1989/12/31 사이 출생한 직원들)
SELECT NAME 이름, BIRTHDAY 생일 FROM T_EMP2 WHERE BIRTHDAY >= '1980-01-01'AND BIRTHDAY < '1990-01-01';



