package com.sam.db.shard.read.write.split.sam_demo_sharding.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TOrderModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    private String userId;
    private String orderId;
    private BigDecimal orderValue;
    private LocalDateTime createdTs;
    private List<TOrderItemModel> orderItems;
}
