DELIMITER //

CREATE PROCEDURE get_avg (monthNo INT, yearNo INT)
BEGIN
SELECT p.name, SUM(p.price) from product p INNER JOIN
orderproducts op on op.product_id = p.id
WHERE MONTH(op.adddate) = monthNo and YEAR(op.adddate) = yearNo
GROUP BY op.product_id;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE get_info_between_date (start DATE, end_date DATE)
BEGIN
IF start > end_date THEN SET start = DATE_SUB(DATE_ADD(LAST_DAY(end_date)
                                     , INTERVAL 1 DAY), INTERVAL 1 MONTH);
END IF;
SELECT orders.id, orders.status FROM orders 
WHERE orders.placed_date BETWEEN start and end_date;

END //

CALL get_info_between_date ("2021-01-01","2021-04-01");
