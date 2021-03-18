select p.ID,p.Name,Price,c.Name from Product p 
left join productCategory pc on pc.PROD_ID = p.ID left join Category c 
on c.ID = pc.Category_id WHERE p.status = "Active" order by p.AddDate ASC;

select * from product p right join ProductImages pi on p.ID
in (select PROD_ID from ProductImages) and p.ID = pi.Prod_ID;

select c.Sub_ID, IFNULL(c.Name,'Top Category'),  c.ID, c.Name from Category c
left join Category sc on c.ID = sc.ID order by 
c.Name,sc.Name;

select c.Sub_ID, c.Name from Category c where c.id NOT IN 
(SELECT sub_ID FROM category WHERE sub_id IS NOT NULL) AND c.sub_id IS NOT NULL;

select p.Name, p.Price, p.Description from Product p, ProductCategory pc, Category c
where p.ID = pc.Prod_ID and pc.Category_ID = c.ID and c.Name = "Mobiles";

select * from Product where Stocks < 50;
