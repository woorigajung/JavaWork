SELECT * FROM t_professor;
----------------------------- 중요 -------------------------------------------
-- null 값 과의 연산 결과는 null 이다!
SELECT name, pay, bonus, pay + bonus
FROM t_professor;

-- 그룹함수에서는 동작 null 은 연산에서 제외되어 동작.
SELECT SUM(pay), sum(BONUS) FROM T_PROFESSOR ;

-- nvl() 함수
SELECT name, pay, bonus,
	pay + bonus,
	PAY + NVL(BONUS, 0) 총지급액 
FROM t_professor;


-- #4201) Professor 테이블 : 101번 학과 교수들의 
-- 이름(name), 급여(pay), 보너스(bonus ), 연봉(pay) 출력하기.
-- 연봉은 pay * 12 + bonus 로 계산,  bonus 가 없는 교수는 0 으로 계산
SELECT NAME ,PAY , NVL(BONUS,0) , PAY * 12 + NVL(BONUS,0) || '만원' 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;
-- #4202)
SELECT NAME ,PAY , NVL2(BONUS,BONUS,0) , PAY * 12 + NVL2(BONUS,BONUS,0) || '만원' 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;
----------------------------- 중요 -------------------------------------------