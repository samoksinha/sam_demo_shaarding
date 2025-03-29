package com.sam.db.shard.read.write.split.sam_demo_sharding.model;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TOrderItemModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    private String userId;
    private String orderId;
    private String itemId;
    private String itemName;
    private Integer itemUnit;
    private String itemUnitValue;
    private BigDecimal itemValue;
    private LocalDateTime createdTs;

}
