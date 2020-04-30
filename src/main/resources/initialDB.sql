CREATE SCHEMA IF NOT EXISTS shopping_list_db default character set utf8;
USE shopping_list_db;

CREATE TABLE IF NOT EXISTS categories
(
    `category_id`   BIGINT      NOT NULL AUTO_INCREMENT,
    `category_name` varchar(45) NOT NULL,
    PRIMARY KEY (`category_id`),
    UNIQUE KEY `category_name_UNIQUE` (`category_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS products
(
    `product_id`          BIGINT        NOT NULL AUTO_INCREMENT,
    `product_name`        varchar(45)   NOT NULL,
    `product_price`       decimal(6, 2) NOT NULL,
    `product_discount`    decimal(4, 2) DEFAULT NULL,
    `product_description` varchar(45)   DEFAULT NULL,
    `product_category`    BIGINT        DEFAULT NULL,
    PRIMARY KEY (`product_id`),
    UNIQUE KEY `product_name_UNIQUE` (`product_name`),
    KEY `category_idx` (`product_category`),
    CONSTRAINT `category` FOREIGN KEY (`product_category`) REFERENCES `shopping_list_db`.categories (`category_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS shopping_carts
(
    `cart_id`   BIGINT      NOT NULL AUTO_INCREMENT,
    `cart_name` varchar(45) NOT NULL,
    PRIMARY KEY (`cart_id`),
    UNIQUE KEY `cart_name_UNIQUE` (`cart_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS shopping_cart_product_list
(
    `list_id`          BIGINT NOT NULL AUTO_INCREMENT,
    `product_id`       BIGINT NOT NULL,
    `shopping_cart_id` BIGINT NOT NULL,
    PRIMARY KEY (`list_id`),
    KEY `shopping_cart_idx` (`shopping_cart_id`),
    KEY `product_idx` (`product_id`),
    CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `shopping_list_db`.products (`product_id`),
    CONSTRAINT `shopping_cart` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_list_db`.shopping_carts (`cart_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1;

insert into `shopping_list_db`.`categories` (`category_name`)
values ('FRUITS');
insert into `shopping_list_db`.`categories` (`category_name`)
values ('MEAT');
insert into `shopping_list_db`.`categories` (`category_name`)
values ('VEGETABLES');
insert into `shopping_list_db`.`categories` (`category_name`)
values ('FISH');

insert into `shopping_list_db`.`products` (`product_name`, `product_price`, `product_discount`,
                                           `product_description`, `product_category`)
values ('orange', 2.69, 0, 'AU', 1);
insert into `shopping_list_db`.`products` (`product_name`, `product_price`, `product_discount`,
                                           `product_description`, `product_category`)
values ('lamb', 18.50, 0, 'IRL', 2);
insert into `shopping_list_db`.`products` (`product_name`, `product_price`, `product_discount`,
                                           `product_description`, `product_category`)
values ('tomato', 2.5, 0, 'LV', 3);
insert into `shopping_list_db`.`products` (`product_name`, `product_price`, `product_discount`,
                                           `product_description`, `product_category`)
values ('halibut', 8.90, 0, 'NOR', 4);

INSERT INTO `shopping_list_db`.`shopping_carts` (`cart_name`)
VALUES ('vegan');
INSERT INTO `shopping_list_db`.`shopping_carts` (`cart_name`)
VALUES ('normal');
INSERT INTO `shopping_list_db`.`shopping_carts` (`cart_name`)
VALUES ('hard');

INSERT INTO `shopping_list_db`.`shopping_cart_product_list` (`product_id`, `shopping_cart_id`)
values (1, 1);
INSERT INTO `shopping_list_db`.`shopping_cart_product_list` (`product_id`, `shopping_cart_id`)
values (4, 1);
INSERT INTO `shopping_list_db`.`shopping_cart_product_list` (`product_id`, `shopping_cart_id`)
values (2, 2);
INSERT INTO `shopping_list_db`.`shopping_cart_product_list` (`product_id`, `shopping_cart_id`)
values (3, 2);

