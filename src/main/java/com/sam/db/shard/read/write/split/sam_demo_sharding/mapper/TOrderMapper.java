package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderEntity;

import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {TOrderItemListMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TOrderMapper {

    TOrderModel toModel(TOrderEntity tOrderEntity);
    TOrderEntity toEntity(TOrderModel tOrderModel);

}