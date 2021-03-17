SELECT p.id, p.name, COUNT(pc.prod_id)
FROM product p INNER JOIN productcategory pc ON p.id = pc.prod_id
GROUP BY pc.prod_id having count(pc.prod_id) > 1;

SELECT rangetable.ranges , count(*) 
FROM (SELECT CASE
       WHEN price > 0 AND price < 100 THEN '0-100'
       WHEN price > 100 AND price < 500 THEN '100-500'
       ELSE 'Above 500' END AS ranges
   FROM product) rangetable
GROUP BY rangetable.ranges;

SELECT c.name, count(*) FROM category c INNER JOIN productcategory pc ON
c.id = pc.category_id GROUP BY pc.category_ID;
