package com.sam.db.shard.read.write.split.sam_demo_sharding.hash;

import com.sam.db.shard.read.write.split.sam_demo_sharding.util.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.springframework.context.ApplicationContext;

import java.math.BigInteger;
import java.util.*;

@Slf4j
public class DatabaseShardingAlgorithm  extends HashUtil implements StandardShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {

        if(Objects.isNull(shardingValue) || Objects.isNull(shardingValue.getValue()))
            throw new UnsupportedOperationException("Cannot find target for value.");

        ApplicationContext applicationContext = ApplicationContextHolder.getContext();
        GenerateHash generateHash = applicationContext.getBean(GenerateHash.class);

        String userIdHash = generateHash.generateUserIdHash(shardingValue.getValue());
        BigInteger userIdHashInt = generateHash.getBigIntegerFromHash(userIdHash);
        BigInteger shardBucket = userIdHashInt.mod(BigInteger.valueOf(availableTargetNames.size()));
        log.info(
                "userId Hash : {} and userIdHashInt : {} generated from userId value : {} and sharding bucket value : {}",
                userIdHash, userIdHashInt, shardingValue.getValue(), shardBucket.intValue()
        );

        for (String targetName : availableTargetNames) {
            if (targetName.endsWith(String.valueOf(shardBucket.intValue()))) {
                return targetName;
            }
        }

        throw new UnsupportedOperationException("Cannot find target for value:" +shardingValue.getValue());
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> rangeShardingValue) {
        log.error(
                "Range sharding is not supported for code, names:{}, value:{}",
                availableTargetNames, rangeShardingValue
        );
        throw new UnsupportedOperationException("Range sharding is not supported for code");
    }
}
