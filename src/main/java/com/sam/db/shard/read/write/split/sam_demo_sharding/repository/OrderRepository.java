package com.sam.db.shard.read.write.split.sam_demo_sharding.repository;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<TOrderEntity, String> {

    List<TOrderEntity> findOrdersByUserId(String userId);

    List<TOrderEntity> findOrderByOrderId(String orderId);

    List<TOrderEntity> findOrderByUserIdAndOrderId(String userId, String orderId);

}
