drop database StoreFront;
create database StoreFront;
use StoreFront;

create table User (User_ID varchar(25) NOT NULL PRIMARY KEY, Name varchar(25));

create table Shopper(Shopper_ID varchar(25),FOREIGN KEY (Shopper_ID) 
                     references User(User_ID), Name varchar(25));
                     
create table ShopperAddress(Shopper_ID varchar(25), FOREIGN KEY(Shopper_ID) references 
                            Shopper(Shopper_ID), Address varchar(25));
                            
create table Category(Category_ID varchar(25) NOT NULL PRIMARY KEY, Name varchar(25));

create table SubCategory (SubCat_ID varchar(25) NOT NULL PRIMARY KEY,
                          Name varchar(25),Category_ID varchar(25),
                          FOREIGN KEY(Category_ID) references Category(Category_ID));
                          
create table Product (Prod_ID varchar(25) NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int, Stocks int, AddDate DATETIME,
                      Description varchar(50));
                      
create table ProductCategory (Prod_ID varchar(25) references Product(Prod_ID),
                              SubCategory_ID varchar(25), 
                              FOREIGN KEY(SubCategory_ID) references SubCategory(SubCat_ID),
                              Category_ID varchar(25), FOREIGN KEY(Category_ID) references
                              Category(Category_ID));
                              
create table ProductImages (Prod_ID varchar(25), FOREIGN KEY(Prod_ID) 
                            references Product(Prod_ID), Image_Link varchar(100));
                            
create table Orders(Order_ID varchar(25) NOT NULL PRIMARY KEY,Shopper_ID varchar(25),
                    FOREIGN KEY(Shopper_ID) 
                    references Shopper(Shopper_ID), Status varchar(25), Shipping_Date DATETIME,
                    Delivery_Date DATETIME);
                    
create table OrderProducts (Order_ID varchar(25),FOREIGN KEY(Order_ID) references Orders(Order_ID) , 
                            Product_ID varchar(25),
                            FOREIGN KEY(Product_ID) references Product(Prod_ID));
                            
create table Admin(Admin_ID varchar(25) NOT NULL PRIMARY KEY, 
                   User_ID varchar(25),FOREIGN KEY(User_ID) references User(User_ID));

show tables;

drop table ProductCategory;
drop table ProductImages;
drop table OrderProducts;
drop table Product;

create table Product (Prod_ID varchar(25) NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int, Stocks int, AddDate DATETIME,
                      Description varchar(50));
                      
create table ProductCategory (Prod_ID varchar(25) references Product(Prod_ID),
                              SubCategory_ID varchar(25), 
                              FOREIGN KEY(SubCategory_ID) references SubCategory(SubCat_ID),
                              Category_ID varchar(25), FOREIGN KEY(Category_ID) references
                              Category(Category_ID));
                              
create table ProductImages (Prod_ID varchar(25), FOREIGN KEY(Prod_ID) 
                            references Product(Prod_ID), Image_Link varchar(100));
                            
create table OrderProducts (Order_ID varchar(25),FOREIGN KEY(Order_ID) references Orders(Order_ID) , 
                            Product_ID varchar(25),
                            FOREIGN KEY(Product_ID) references Product(Prod_ID));