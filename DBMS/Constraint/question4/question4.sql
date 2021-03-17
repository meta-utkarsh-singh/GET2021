CREATE TABLE state(state_id INTEGER AUTO_INCREMENT,
                   state_name VARCHAR(20),
                   PRIMARY KEY(state_id));  

CREATE TABLE city(city_id INTEGER AUTO_INCREMENT PRIMARY KEY,
                  city_name VARCHAR(20),
                  state_id INTEGER,
                  FOREIGN KEY(state_id) REFERENCES state(state_id));

CREATE TABLE zipcode(zipcode CHAR(6) PRIMARY KEY,
                     city_id INTEGER,
                     FOREIGN KEY(city_id) REFERENCES city(city_id));

INSERT INTO state(state_name)
VALUES("Rajasthan"),
	    ("Tamil Nadu"),
      ("Karnataka"),
      ("Madhya Pradesh"),
      ("Kerala");
      
INSERT INTO city(city_name,state_id)
VALUES("Jodhpur", 1),
	    ("Jaipur", 1),
      ("Chennai", 2),
      ("Bengaluru", 3),
      ("Mangalore", 3),
      ("Indore", 4),
      ("Gwalior", 4),
      ("Thiruvanantpuram", 5);

INSERT INTO zipcode(zipcode,city_id)
VALUES("11", 1),
	    ("12", 1),
      ("13", 1),
      ("14", 2),
      ("15", 2),
      ("16", 4),
      ("17", 4),
      ("18", 4),
      ("19", 4),
      ("20", 2),
      ("21", 5),
      ("22", 1),
      ("23", 3);
      
SELECT s.state_name, c.city_name, z.zipcode FROM state s
INNER JOIN city c ON c.state_id = s.state_id 
INNER JOIN zipcode z ON z.city_id = c.city_id
ORDER BY s.state_name, c.city_name;
