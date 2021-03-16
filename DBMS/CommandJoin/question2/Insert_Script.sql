use StoreFront;

insert into User VALUES (1, "A"), (2, "B"),
                        (3, "C"),(4, "D"),
                        (5, "E");

insert into Shopper VALUES (1, "A"), (2, "B"),
                        (3, "C"),(4, "D");

insert into ShopperAddress VALUES (1, "Address1"), (2, "Address2"),
                                  (3, "Address3"),(4, "Address4");

insert into Category VALUES (1 , "Mobiles"), (2 , "Clothing"),
                            (3 , "Grocery"), (4, "Utensils"),
                            (5 , "Electronics"), (6 , "Laptops");
                            
insert into SubCategory VALUES (11 , "Kids", 2), (21, "Men", 2),
                               (3, "Women", 2), (51, "Utility", 6),
                               (61, "Gaming", 6), (71, "Business", 6),
                               (81, "AC", 5), (9, "Refrigerator", 5);

insert into Product Values (1, "Shirt", 1000, 50,CAST(N'2012-06-18 10:34:09.000' AS DateTime), "Shirt"),
                           (2, "Pants", 1000, 50,CAST(N'2012-07-18 10:34:09.000' AS DateTime), "Shirt"),
                           (3, "Nokia", 1000, 30,CAST(N'2012-06-18 10:35:09.000' AS DateTime), "Mobile"),
                           (4, "Samsung", 1000, 50,CAST(N'2012-06-19 10:34:09.000' AS DateTime), "Mobile"),
                           (5, "Stove", 1000, 50,CAST(N'2012-03-19 10:34:09.000' AS DateTime), "Utensil"),
                           (6, "Dell", 1000, 50,CAST(N'2012-06-19 10:34:09.000' AS DateTime), "Laptop utility"),
                           (7, "Acer", 1000, 50,CAST(N'2012-06-19 11:34:09.000' AS DateTime), "Laptop gaming"),
                           (8, "Cooking oil", 1000, 50,CAST(N'2012-06-19 09:34:09.000' AS DateTime), "Grocery"),
                           (9, "Samsung AC", 1000, 50,CAST(N'2012-06-19 12:34:09.000' AS DateTime), "AC"),
                           (10, "LG", 1000, 41,CAST(N'2012-06-19 10:34:09.000' AS DateTime), "refrigerator");
                           
insert into ProductImages VALUES (1,"image1"),(1,"image2"),
                                 (2,"image1"),(3,"image1"),
                                 (3,"image2"),(3,"image3"),
                                 (4,"image1"),(5,"image1"),
                                 (6,"image1"),(6,"image2"),
                                 (7,"image1"),(8,"image1"),
                                 (9,"image1"),(9,"image2");

insert into ProductCategory VALUES (1, 11, 2), (2, 21, 2),
                                   (3, NULL, 1), (4, NULL, 1),
                                   (5, NULL, 4), (6, 51, 6),
                                   (7, 61, 6),(8, NULL, 3),
                                   (9, 81, 5),(10, 9, 5);

insert into Orders VALUES 
(1, 1, "Shipped", CAST(N'2021-03-10 11:34:09.000' AS DateTime), 
CAST(N'2021-07-19 11:34:09.000' AS DateTime), 2000),
(2, 2, "Shipped", CAST(N'2021-03-09 11:34:09.000' AS DateTime), 
CAST(N'2021-09-19 11:34:09.000' AS DateTime), 3000),
(3, 3, "Shipped", CAST(N'2021-10-19 11:34:09.000' AS DateTime), 
CAST(N'2021-11-19 11:34:09.000' AS DateTime), 1000),
(4, 3, "Ordered", CAST(N'2021-01-19 11:34:09.000' AS DateTime), 
CAST(N'2021-11-19 11:34:09.000' AS DateTime), 1000),
(5, 2, "Ordered", CAST(N'2021-03-03 11:34:09.000' AS DateTime), 
CAST(N'2021-11-19 11:34:09.000' AS DateTime), 1000);

insert into OrderProducts VALUES (1,1,"Shipped",CAST(N'2021-06-19 11:34:09.000' AS DateTime)), 
                                 (1,9,"Shipped",CAST(N'2021-06-19 11:34:09.000' AS DateTime)), 
                                 (2,10,"Shipped",CAST(N'2021-05-19 11:34:09.000' AS DateTime)), 
                                 (2,7,"Shipped",CAST(N'2021-05-19 11:34:09.000' AS DateTime)),
                                 (2,8,"Shipped",CAST(N'2021-05-19 11:34:09.000' AS DateTime)), 
                                 (3,1,"Shipped",CAST(N'2021-10-19 11:34:09.000' AS DateTime)),
                                 (5,2,"Ordered",CAST(N'2021-03-03 11:34:09.000' AS DateTime)),
                                 (4,3,"Shipped",CAST(N'2021-01-19 11:34:09.000' AS DateTime));
                                