CREATE TABLE test_emp_a(
emp_id NUMBER,
emp_name Varchar2(100)
);


CREATE TABLE test_emp_b(
emp_id NUMBER,
emp_name Varchar2(100)
);

DELETE FROM TEST_EMP_A;
DELETE FROM TEST_EMP_B;

INSERT INTO TEST_EMP_A VALUES(101,'장윤성');
INSERT INTO TEST_EMP_b VALUES(201,'고유성');

SELECT * FROM TEST_EMP_A;
SELECT * FROM TEST_EMP_b;


-- 알아만 둬라 쓸일 아예 없을 듯
-- 동시에 여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT 구문에 sub query 필요
INSERT ALL
	INTO TEST_EMP_A values(102,'조현주')
	INTO TEST_EMP_b values(202,'최현주')
SELECT * FROM DUAL;


-- sub query 로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400, '강감찬' FROM DUAL);
INSERT INTO TEST_EMP_b (SELECT 500, '교감찬' FROM DUAL);

-- 테이블 묻고 더블로!
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A);
SELECT *FROM TEST_EMP_A;

INSERT  INTO
TEST_EMP_A (emp_name) (SELECT emp_name FROM TEST_EMP_A)