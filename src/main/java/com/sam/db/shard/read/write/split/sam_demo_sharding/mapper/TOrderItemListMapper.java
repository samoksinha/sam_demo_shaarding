package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderItemEntity;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderItemModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        uses = {TOrderItemMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TOrderItemListMapper {

    List<TOrderItemModel> toModelList(List<TOrderItemEntity> tOrderItemEntityList);
    List<TOrderItemEntity> toEntityList(List<TOrderItemModel> tOrderItemModelList);

}