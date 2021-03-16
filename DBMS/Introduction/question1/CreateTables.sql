create database StoreFront;
use StoreFront;
create table User (User_ID varchar(25) NOT NULL PRIMARY KEY, Name varchar(25));
create table Shopper(Shopper_ID varchar(25) references User(User_ID));
create table Category(Category_ID varchar(25), Name varchar(25));
create table SubCategory (SubCat_ID varchar(25) NOT NULL PRIMARY KEY,
                          Name varchar(25), Category_ID varchar(25) references Category(Category_ID));
create table Product (Prod_ID varchar(25) NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int);
create table ProductCategory (Prod_ID varchar(25) references Product(Prod_ID),
                              SubCategory_ID varchar(25) references SubCategory(SubCat_ID));
create table ProductImages (Prod_ID varchar(25) references Product(Prod_ID), Image_Link varchar(100));
create table Orders(Order_ID varchar(25) NOT NULL PRIMARY KEY, Shopper_ID 
                    varchar(25) references Shopper(Shopper_ID));
create table OrderProducts (Order_ID varchar(25) NOT NULL PRIMARY KEY , 
                            Product_ID varchar(25) references Product(Prod_ID));
create table Admin(Admin_ID varchar(25) NOT NULL PRIMARY KEY, 
                   User_ID varchar(25) references User(User_ID));
show tables;
drop table Product;
create table Product (Prod_ID varchar(25) NOT NULL PRIMARY KEY,
                      Name varchar(25), Price int);
