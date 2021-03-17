DELIMITER //
CREATE FUNCTION number_of_orders (monthNo INT, yearNo INT)
RETURNS INT
BEGIN
    DECLARE ans INT;
    SELECT COUNT(*) INTO ans FROM orders 
    WHERE MONTH(placed_date) = monthNo and  YEAR(placed_date) = yearNo;
    
    RETURN ans;
    
END //

Select number_of_orders(03,2021)//

DELIMITER ;
SELECT number_of_orders(03,2021);
SELECT * FROM orders;

DELIMITER //
CREATE FUNCTION highest_order (yearNo INT)
    RETURNS INT 
BEGIN
    DECLARE ans INT;
    SELECT month_loop.month_ans
    FROM
    (SELECT number_of_orders(MONTH(orders.placed_date), yearNo) AS month_order,
     MONTH(orders.placed_date) AS month_ans FROM orders WHERE
     orders.placed_date IS NOT NULL
     GROUP BY MONTH(orders.placed_date)
     ORDER BY month_order DESC LIMIT 1) month_loop
     INTO ans;
     RETURN ans;
END //

SELECT highest_order (2021)//