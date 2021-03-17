CREATE VIEW order_60_day AS
SELECT o.order_id,p.name, o.total, s.name AS S_NAME, s.email, o.placed_date, o.status
FROM shopper s INNER JOIN orders o ON s.shopper_id = o.shopper_id
INNER JOIN orderproducts op ON op.order_id = o.order_id
INNER JOIN product p ON p.prod_id = op.product_id
WHERE op.adddate > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.placed_date;

SELECT * FROM order_60_day;

SELECT name FROM order_60_day WHERE 
status = "Shipped";