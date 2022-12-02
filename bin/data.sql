/*User*/
INSERT INTO user (username, ´password´,userType) VALUES ('John','123','ADMIN');
INSERT INTO user (username, ´password´,userType) VALUES ('Sophie','123','DAMAGE_REG');
INSERT INTO user (username, ´password´,userType) VALUES ('Jesus','123','DATA_REG');
INSERT INTO user (username, ´password´,userType) VALUES ('Bob','123','BUSINESS');

/*Customer*/
INSERT INTO customer (givenname,lastname, gender, address, contactNo, email) VALUES ('John','Johnson','MALE','St. Johns Ave.', '+45 John','John@kea.com');

/*Card*/
INSERT INTO card (´name´, cardNo, csc, exp, idCustomer) VALUES ('John Johnson',0000001042,666,'2022-12-01',1)

