SELECT s.id, s.name, COUNT(o.shopper_id) from shopper s
INNER JOIN orders o ON s.id = o.shopper_id 
where o.placed_date > DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY o.shopper_id;

SELECT s.id, s.name, SUM(o.total) FROM shopper s INNER JOIN 
orders o ON o.shopper_id = s.id WHERE o.placed_date > DATE_SUB(CURDATE(), INTERVAL 30 DAY)
GROUP BY o.shopper_id
ORDER BY SUM(o.total) DESC LIMIT 10;

SELECT p.id, p.name, COUNT(op.product_id) FROM product p INNER JOIN
orderproducts op ON p.id = op.product_id INNER JOIN orders o ON
o.id = op.order_id WHERE o.placed_date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
GROUP BY op.product_id
ORDER BY COUNT(op.product_id) DESC
LIMIT 20;

SELECT MONTHNAME(o.placed_date), SUM(o.total) FROM orders o
where o.placed_date > DATE_SUB(CURDATE(), INTERVAL 6 MONTH) AND
o.placed_date <= CURDATE()
GROUP BY MONTH(o.placed_date);

SET SQL_SAFE_UPDATES = 0;

UPDATE product p SET product_state = "Inactive"
WHERE p.prod_id NOT IN 
(SELECT op.product_id FROM orderproducts op WHERE
op.adddate > DATE_SUB(CURDATE(), INTERVAL 90 DAY));

SELECT p.prod_id, p.name FROM product p INNER JOIN
productcategory pc ON p.prod_id = pc.prod_id 
INNER JOIN category c ON pc.category_id = c.category_id
WHERE c.name = "Mobiles";

UPDATE orderproducts SET status = "Cancelled"
WHERE order_id = 1 OR order_id = 3;

SELECT p.prod_id, p.name, COUNT(op.product_id) FROM
product p INNER JOIN orderproducts op ON op.product_id = p.prod_id
WHERE op.status = "Cancelled"
GROUP BY op.product_id
ORDER BY COUNT(op.product_id) DESC;





