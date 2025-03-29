package com.sam.db.shard.read.write.split.sam_demo_sharding.repository;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<TOrderItemEntity, String> {

    List<TOrderItemEntity> findByUserId(String userId);

    List<TOrderItemEntity> findByOrderId(String orderId);

    List<TOrderItemEntity> findByUserIdAndOrderId(String userId, String orderId);
}
