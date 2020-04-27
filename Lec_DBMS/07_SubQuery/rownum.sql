-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT EMPNO ,ENAME ,SAL FROM  T_EMP ;


-- 자동적으로 오라클에서 붙여주는 행번호 객체(ROWNUM)
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM  T_EMP ;
-- 직원번호 역순, 그러나 ROWNUM 은 똑같다
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM  T_EMP ORDER BY empno DESC;

-- 상위 5개만!
SELECT ROWNUM, EMPNO ,ENAME ,SAL FROM  T_EMP
WHERE ROWNUM <= 5 ORDER BY EMPNO DESC;

-- SELECT 에 ROWNUM 없어도 동작
SELECT EMPNO ,ENAME ,SAL FROM  T_EMP
WHERE ROWNUM <= 5 ORDER BY EMPNO DESC;

-- ROWNUM > 5 ??? 동작안함... ROWNUM 범위가 1이 포함안되면 동작안함.
SELECT EMPNO ,ENAME ,SAL FROM  T_EMP
WHERE ROWNUM > 5 
ORDER BY empno DESC;


-- 상위 5개 출력
-- row1 ~ row5 까지 출력 (1 page)
SELECT EMPNO ,ENAME ,SAL FROM  T_EMP
WHERE ROWNUM >= 1 AND Rownum < 1 + 5 
ORDER BY empno DESC;

-- +5

-- (2 page)
SELECT EMPNO ,ENAME ,SAL FROM  T_EMP
WHERE ROWNUM >= 6 AND Rownum < 6 + 5 
ORDER BY empno DESC; -- 안나옴

-- phonebook 뻥튀기
SELECT * FROM PHONEBOOK;
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK); -- 에러 PRIMARY KEY 중복

INSERT INTO PHONEBOOK
	(SELECT phonebook_seq.nextval, PB_NAME, PB_PHONENUM ,PB_MEMO ,SYSDATE from PHONEBOOK);

	
-- ROWNUM rev.
SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC;

SELECT T.*
FROM(SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC) T;

SELECT rownum AS RNUM, T.*
FROM(SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC) T;


-- 이 때부터는 rownum 이아니라 sellect에서 뽑아진 정수값이다
-- 한 페이지 당 5개 데이터
-- 두번째 페이지
SELECT * FROM 
(SELECT rownum AS RNUM, T.*
FROM(SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC) T)
WHERE rnum >= 6 AND rnum > 6+5;

-- 세번째 페이지
SELECT * FROM 
(SELECT rownum AS RNUM, T.*
FROM(SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC) T)
WHERE rnum >= 11 AND rnum > 11+5;

-- 한 페이지 당 10개 데이터
-- 그중 세번째 페이지
SELECT * FROM 
(SELECT rownum AS RNUM, T.*
FROM(SELECT pb_uid, pb_name, PB_PHONENUM 
FROM PHONEBOOK 	
ORDER BY PB_UID DESC) T)
WHERE rnum >= 21 AND rnum > 21+10;