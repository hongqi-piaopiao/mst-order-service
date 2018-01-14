CREATE TABLE `t_shopping_cart_goods` (
  `id`       VARCHAR(255) NOT NULL PRIMARY KEY,
  `good_id`  VARCHAR(255) NOT NULL,
  `quantity` BIGINT(20) DEFAULT 0,
  `shopping_cart_id` VARCHAR(255) NOT NULL
);