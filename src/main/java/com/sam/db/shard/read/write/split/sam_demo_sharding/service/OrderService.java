package com.sam.db.shard.read.write.split.sam_demo_sharding.service;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderEntity;
import com.sam.db.shard.read.write.split.sam_demo_sharding.hash.GenerateHash;
import com.sam.db.shard.read.write.split.sam_demo_sharding.mapper.TOrderListMapper;
import com.sam.db.shard.read.write.split.sam_demo_sharding.mapper.TOrderMapper;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import com.sam.db.shard.read.write.split.sam_demo_sharding.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final TOrderListMapper tOrderListMapper;
    private final TOrderMapper tOrderMapper;
    private final GenerateHash generateHash;

    public OrderService(OrderRepository orderRepository,
                        TOrderListMapper tOrderListMapper,
                        TOrderMapper tOrderMapper,
                        GenerateHash generateHash) {

        this.orderRepository = orderRepository;
        this.tOrderListMapper = tOrderListMapper;
        this.tOrderMapper = tOrderMapper;
        this.generateHash = generateHash;
    }

    @Transactional
    public TOrderModel saveOrder(TOrderModel orderModel) {
        TOrderEntity order = this.tOrderMapper.toEntity(orderModel);

        order.setCreatedTs(LocalDateTime.now());
        order.setOrderId(generateHash
                .generateOrderIdHash(order.getUserId(), order.getCreatedTs()));
        order.getOrderItems().forEach(item -> {
            item.setUserId(order.getUserId());
            item.setOrderId(order.getOrderId());
            item.setItemId(generateHash.
                    generateItemIdHash(item.getItemName(), order.getCreatedTs()));
            item.setOrderItemId(generateHash
                    .generateOrderItemIdHash(order.getOrderId(), item.getItemId(), order.getCreatedTs()));
            item.setCreatedTs(LocalDateTime.now());
            item.setTOrderEntity(order);
        });

        //TOrderEntity entity = orderRepository.save(order);
        //Hibernate.initialize(entity.getOrderItems());
        return this.tOrderMapper.toModel(orderRepository.save(order));
    }

    @Transactional
    public List<TOrderModel> findAllUsersOrders() {
        //List<TOrderEntity> entities = orderRepository.findAll();
        return this.tOrderListMapper.toModelList(orderRepository.findAll());
    }

    @Transactional
    public TOrderModel findByOrderId(String orderId) {
        //List<TOrderEntity> entities = orderRepository.findOrderByOrderId(orderId);
        return this.tOrderMapper.toModel(orderRepository
                .findOrderByOrderId(orderId).stream().findFirst().orElse(null));
    }

    @Transactional
    public List<TOrderModel> findByUserId(String userId) {
        //List<TOrderEntity> entities = orderRepository.findOrdersByUserId(userId);
        return this.tOrderListMapper.toModelList(orderRepository.findOrdersByUserId(userId));
    }

    @Transactional
    public TOrderModel findByUserIdOrderId(String userId, String orderId) {
        //List<TOrderEntity> entities = orderRepository.findOrderByUserIdAndOrderId(userId, orderId);
        /*entities.forEach(entity
                -> Hibernate.initialize(entity.getOrderItems()));*/
        return this.tOrderMapper.toModel(orderRepository
                .findOrderByUserIdAndOrderId(userId, orderId).stream().findFirst().orElse(null));
    }

}
