package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrder;
import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderItem;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderItemModel;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-28T12:07:19+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Azul Systems, Inc.)"
)
@Component
public class TOrderMapperImpl implements TOrderMapper {

    @Override
    public TOrderModel entityToModel(TOrder tOrder) {
        if ( tOrder == null ) {
            return null;
        }

        TOrderModel tOrderModel = new TOrderModel();

        tOrderModel.setUserId( tOrder.getUserId() );
        tOrderModel.setOrderId( tOrder.getOrderId() );
        tOrderModel.setOrderValue( tOrder.getOrderValue() );
        tOrderModel.setCreatedTs( tOrder.getCreatedTs() );
        tOrderModel.setOrderItems( tOrderItemListToTOrderItemModelList( tOrder.getOrderItems() ) );

        return tOrderModel;
    }

    @Override
    public TOrder modelToEntity(TOrderModel tOrderModel) {
        if ( tOrderModel == null ) {
            return null;
        }

        TOrder tOrder = new TOrder();

        tOrder.setOrderId( tOrderModel.getOrderId() );
        tOrder.setUserId( tOrderModel.getUserId() );
        tOrder.setOrderValue( tOrderModel.getOrderValue() );
        tOrder.setCreatedTs( tOrderModel.getCreatedTs() );
        tOrder.setOrderItems( tOrderItemModelListToTOrderItemList( tOrderModel.getOrderItems() ) );

        return tOrder;
    }

    @Override
    public List<TOrderModel> entitiesToModels(List<TOrder> models) {
        if ( models == null ) {
            return null;
        }

        List<TOrderModel> list = new ArrayList<TOrderModel>( models.size() );
        for ( TOrder tOrder : models ) {
            list.add( entityToModel( tOrder ) );
        }

        return list;
    }

    @Override
    public List<TOrder> modelsToEntities(List<TOrderModel> models) {
        if ( models == null ) {
            return null;
        }

        List<TOrder> list = new ArrayList<TOrder>( models.size() );
        for ( TOrderModel tOrderModel : models ) {
            list.add( modelToEntity( tOrderModel ) );
        }

        return list;
    }

    @Override
    public TOrderItemModel map(TOrderItem value) {
        if ( value == null ) {
            return null;
        }

        TOrderItemModel tOrderItemModel = new TOrderItemModel();

        return tOrderItemModel;
    }

    @Override
    public TOrderItem map(TOrderItemModel value) {
        if ( value == null ) {
            return null;
        }

        TOrderItem tOrderItem = new TOrderItem();

        return tOrderItem;
    }

    protected List<TOrderItemModel> tOrderItemListToTOrderItemModelList(List<TOrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<TOrderItemModel> list1 = new ArrayList<TOrderItemModel>( list.size() );
        for ( TOrderItem tOrderItem : list ) {
            list1.add( map( tOrderItem ) );
        }

        return list1;
    }

    protected List<TOrderItem> tOrderItemModelListToTOrderItemList(List<TOrderItemModel> list) {
        if ( list == null ) {
            return null;
        }

        List<TOrderItem> list1 = new ArrayList<TOrderItem>( list.size() );
        for ( TOrderItemModel tOrderItemModel : list ) {
            list1.add( map( tOrderItemModel ) );
        }

        return list1;
    }
}
