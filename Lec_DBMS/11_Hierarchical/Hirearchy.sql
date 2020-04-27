-- 계층형 쿼리 (HIREARCHICAL QUERY)

SELECT * FROM T_DEPT2; -- 서로의 계층관계 주목!

SELECT LPAD(dname, 10, '*') 부서명 FROM T_DEPT2 ;

-- LEVER
SELECT DNAME , LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR dcode = PDEPT
START WITH DCODE = 0001
;
-- level 생성될 때마다 그냥 1씩증가
/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

-- PRIOR 를 다른데 주면??
SELECT DNAME , LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT
START WITH DCODE = 0001
;
-- start with 에 입력된 값이 부모를 찾아간다

SELECT DCODE, DNAME, PDEPT, LEVEL 
FROM T_DEPT2 
CONNECT BY dcode = PRIOR PDEPT
--START WITH DCODE = 1005 -- S/W지원(1) -> 기술부(2) -> 사장실(3)
START WITH  DCODE = 1011 -- 영업4팀 - 영업기획팀 - 영업부 - 사장실
;

SELECT LPAD(DNAME , LEVEL * 6, '*') 부서명
FROM T_DEPT2 
CONNECT BY PRIOR DCODE = PDEPT 
START WITH dcode = 0001;

----------
SELECT * FROM T_EMP2;

SELECT LPAD(e.NAME || ' ' || d.dname || NVL(e.POST, '사원') , LEVEL * 22, '~') "이름과 직급"
FROM  T_EMP2 e,(SELECT dname, dcode, pdept FROM T_DEPT2) d
WHERE e.DEPTNO = d.dcode
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO = 20000101
;


SELECT LEVEL -1 hr
FROM DUAL 
CONNECT BY LEVEL <= 24;

-- 입양 시각 구하기(2)
-- https://programmers.co.kr/learn/courses/30/lessons/59039
select h.hr HOUR, count(datetime) COUNT
from 
    (SELECT LEVEL -1 HR FROM DUAL CONNECT BY LEVEL <= 24) h
    LEFT OUTER JOIN ANIMAL_OUTS a
    on h.hr = to_NUMBER(to_CHAR(a.datetime, 'hh24'))
    group by h.hr order by 1
    ;
