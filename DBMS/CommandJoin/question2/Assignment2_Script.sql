select p.Prod_ID,p.Name,Price,c.Name from Product p 
left join productCategory pc on pc.PROD_ID = p.PROD_ID left join Category c 
on c.Category_ID = pc.Category_id order by p.AddDate ASC;

select * from product p right join ProductImages pi on p.Prod_ID
in (select PROD_ID from ProductImages) and p.Prod_ID = pi.Prod_ID;

select sc.SubCat_ID, IFNULL(sc.Name,'Top Category'),  c.Category_ID, c.Name from Category c
left join SubCategory sc on c.Category_ID = sc.Category_ID order by 
c.Name,sc.Name;

select sc.SubCat_ID, sc.Name, c.Name from Category c left join SubCategory sc on 
sc.Category_ID = c.Category_ID where sc.SubCat_ID not in (Select Category_ID from category);

select p.Name, p.Price, p.Description from Product p, ProductCategory pc, Category c
where p.Prod_ID = pc.Prod_ID and pc.Category_ID = c.Category_ID and c.Name = "Mobiles";

select * from Product where Stocks < 50;
