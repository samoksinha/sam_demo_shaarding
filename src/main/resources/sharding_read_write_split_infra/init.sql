create table if not exists t_order
(
    order_id	     VARCHAR(20) NOT NULL,
    user_id          VARCHAR(50) NOT NULL,
    order_value      DECIMAL(8, 2),
    created_ts       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_ts       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY t_order_pk (order_id)
);

create table if not exists t_order_item
(
    order_item_id    VARCHAR(20) NOT NULL,
    user_id          VARCHAR(50),
    order_id         VARCHAR(20),
    item_id          VARCHAR(20),
    item_name        VARCHAR(255),
    item_unit        INTEGER,
    item_unit_value  DECIMAL(8, 2),
    item_value       DECIMAL(8, 2),
    created_ts       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_ts       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY t_order_item_pk (order_item_id),
    FOREIGN KEY t_order_item_fk (order_id) REFERENCES t_order(order_id)
);