CREATE TABLE transactions (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
 customer_id INTEGER NOT NULL,
  amount DOUBLE NOT NULL,
  purchase_date   DATE NOT NULL);