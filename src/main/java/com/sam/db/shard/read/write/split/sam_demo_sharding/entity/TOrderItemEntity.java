package com.sam.db.shard.read.write.split.sam_demo_sharding.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_order_item")
public class TOrderItemEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "order_item_id", length = 20)
    private String orderItemId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "order_id", length = 20)
    private String orderId;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    })
    private TOrderEntity tOrderEntity;

    @Column(name = "item_id", length = 20)
    private String itemId;

    @Column(name = "item_name", length = 255)
    private String itemName;

    @Column(name = "item_unit")
    private Integer itemUnit;

    @Column(name = "item_unit_value", precision = 8, scale = 2)
    private BigDecimal itemUnitValue;

    @Column(name = "item_value", precision = 8, scale = 2)
    private BigDecimal itemValue;

    @Column(name = "created_ts", nullable = false, updatable = false)
    private LocalDateTime createdTs;

    @Column(name = "updated_ts")
    private LocalDateTime updatedTs;

}
