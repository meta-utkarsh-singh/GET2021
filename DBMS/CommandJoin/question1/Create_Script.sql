drop database StoreFront;
create database StoreFront;
use StoreFront;

create table User (ID INTEGER NOT NULL PRIMARY KEY, Name varchar(25));

create table Shopper(id INTEGER PRIMARY KEY ,user_id INTEGER,FOREIGN KEY (user_ID) 
                     references User(ID), Name varchar(25), Email varchar(50));
                     
create table ShopperAddress(Shopper_ID INTEGER PRIMARY KEY, FOREIGN KEY(Shopper_ID) references 
                            Shopper(id), Address varchar(25));
                            
create table Category(ID INTEGER PRIMARY KEY, Name varchar(25), sub_id INTEGER, 
FOREIGN KEY(sub_id) REFERENCES category(id));
                          
create table Product (ID INTEGER NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int, Stocks int, AddDate DATETIME,
                      Description varchar(50), status varchar(25));
                      
create table ProductCategory (ID INTEGER references Product(ID),
                              SubCategory_ID INTEGER, 
                              FOREIGN KEY(SubCategory_ID) references Category(Sub_ID),
                              Category_ID INTEGER, FOREIGN KEY(Category_ID) references
                              Category(ID));
                              
create table ProductImages (Prod_ID INTEGER, FOREIGN KEY(Prod_ID) 
                            references Product(ID), Image_Link varchar(100));
                            
create table Orders(ID INTEGER NOT NULL PRIMARY KEY,Shopper_ID INTEGER,
                    FOREIGN KEY(Shopper_ID) 
                    references Shopper(ID), Status varchar(25), Placed_Date DATETIME,
                    Delivery_Date DATETIME, Total int);
                    
create table OrderProducts (Order_ID INTEGER,FOREIGN KEY(Order_ID) references Orders(ID) , 
                            Product_ID INTEGER,
                            FOREIGN KEY(Product_ID) references Product(ID),
                            Status varchar(50), AddDate DATETIME);
                            
create table Admin(Admin_ID INTEGER NOT NULL PRIMARY KEY, 
                   User_ID INTEGER,FOREIGN KEY(User_ID) references User(ID));

show tables;

drop table ProductCategory;
drop table ProductImages;
drop table OrderProducts;
drop table Product;

create table Product (ID INTEGER NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int, Stocks int, AddDate DATETIME,
                      Description varchar(50), status varchar(25));
                      
create table ProductCategory (prod_ID INTEGER references Product(ID),
                              SubCategory_ID INTEGER, 
                              FOREIGN KEY(SubCategory_ID) references Category(ID),
                              Category_ID INTEGER, FOREIGN KEY(Category_ID) references
                              Category(ID));
                              
create table ProductImages (Prod_ID INTEGER, FOREIGN KEY(Prod_ID) 
                            references Product(ID), Image_Link varchar(100));
                            
create table OrderProducts (Order_ID INTEGER,FOREIGN KEY(Order_ID) references Orders(ID) , 
                            Product_ID INTEGER,
                            FOREIGN KEY(Product_ID) references Product(ID),
                            Status varchar(50), AddDate DATETIME);