package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderEntity;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T15:36:12+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Azul Systems, Inc.)"
)
@Component
public class TOrderMapperImpl implements TOrderMapper {

    private final TOrderItemListMapper tOrderItemListMapper;

    @Autowired
    public TOrderMapperImpl(TOrderItemListMapper tOrderItemListMapper) {

        this.tOrderItemListMapper = tOrderItemListMapper;
    }

    @Override
    public TOrderModel toModel(TOrderEntity tOrderEntity) {
        if ( tOrderEntity == null ) {
            return null;
        }

        TOrderModel tOrderModel = new TOrderModel();

        tOrderModel.setUserId( tOrderEntity.getUserId() );
        tOrderModel.setOrderId( tOrderEntity.getOrderId() );
        tOrderModel.setOrderValue( tOrderEntity.getOrderValue() );
        tOrderModel.setCreatedTs( tOrderEntity.getCreatedTs() );
        tOrderModel.setOrderItems( tOrderItemListMapper.toModelList( tOrderEntity.getOrderItems() ) );

        return tOrderModel;
    }

    @Override
    public TOrderEntity toEntity(TOrderModel tOrderModel) {
        if ( tOrderModel == null ) {
            return null;
        }

        TOrderEntity tOrderEntity = new TOrderEntity();

        tOrderEntity.setOrderId( tOrderModel.getOrderId() );
        tOrderEntity.setUserId( tOrderModel.getUserId() );
        tOrderEntity.setOrderValue( tOrderModel.getOrderValue() );
        tOrderEntity.setCreatedTs( tOrderModel.getCreatedTs() );
        tOrderEntity.setOrderItems( tOrderItemListMapper.toEntityList( tOrderModel.getOrderItems() ) );

        return tOrderEntity;
    }
}
