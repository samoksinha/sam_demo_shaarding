package com.sam.db.shard.read.write.split.sam_demo_sharding.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "t_order")
public class TOrderEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_id", length = 20)
    private String orderId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "order_value", precision = 8, scale = 2)
    private BigDecimal orderValue;

    @Column(name = "created_ts", nullable = false, updatable = false)
    private LocalDateTime createdTs;

    @Column(name = "updated_ts")
    private LocalDateTime updatedTs;

    @OneToMany(mappedBy = "tOrderEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TOrderItemEntity> orderItems = new ArrayList<>();

}



