# Block Loot API

Based off of: [https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/](https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/)

## Instructions
Create a MYSQL db

```
CREATE DATABASE `crypto_data`
```

Create a table to hold scraped info

```
CREATE TABLE `prices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)
```

Fill table with crypto data.

Run BlockLootApplicaiton.java