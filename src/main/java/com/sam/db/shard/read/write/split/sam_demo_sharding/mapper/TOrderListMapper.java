package com.sam.db.shard.read.write.split.sam_demo_sharding.mapper;

import com.sam.db.shard.read.write.split.sam_demo_sharding.entity.TOrderEntity;
import com.sam.db.shard.read.write.split.sam_demo_sharding.model.TOrderModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {TOrderMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TOrderListMapper {

    List<TOrderModel> toModelList(List<TOrderEntity> tOrderEntity);
    List<TOrderEntity> toEntityList(List<TOrderModel> tOrderModel);

}