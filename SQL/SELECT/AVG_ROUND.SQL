-- AVERAGE 가 아니라 AVG로 써야한다.
-- 문자열을 큰 따옴표가 아닌 작은 따옴표로 써야한다.
-- ROUND 함수를 통해 반올림
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = 'SUV';