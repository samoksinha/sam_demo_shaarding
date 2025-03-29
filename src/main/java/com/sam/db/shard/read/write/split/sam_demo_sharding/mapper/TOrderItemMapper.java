package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderItemEntity;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderItemModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TOrderItemMapper {

    TOrderItemModel toModel(TOrderItemEntity tOrderItemEntity);
    TOrderItemEntity toEntity(TOrderItemModel tOrderItemModel);

}