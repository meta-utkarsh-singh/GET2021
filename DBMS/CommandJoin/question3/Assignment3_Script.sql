select Order_ID, Placed_Date, Delivery_Date from Orders order by Placed_Date DESC limit 50;

select * from Orders order by total DESC limit 10;

select * from orders where CURDATE() > DATE_ADD(Placed_Date, INTERVAL 10 DAY)
and Order_ID in (Select Order_ID from OrderProducts where Status = "Ordered");

select * from Shopper where Shopper_ID not in 
(Select Shopper_ID from Orders where Placed_Date > DATE_SUB(CURDATE() , INTERVAL 1 MONTH));

select s.Shopper_ID, s.Name, o.Order_ID from Shopper s, Orders o where
o.Shopper_ID = s.Shopper_ID and o.Placed_Date > DATE_SUB(CURDATE() , INTERVAL 15 DAY);

select p.Name from Product p left join OrderProducts op on p.Prod_ID = op.Product_ID
where op.Status = "Shipped" and op.Order_ID = 1;

select p.Name, op.AddDate from Product p left join orderProducts op on p.Prod_ID = op.Product_ID
where op.Order_ID in (Select Order_ID from Orders where Total > 1500 and Total < 4500);

