package com.sam.db.shard.read.write.split.sam_demo_sharding.loadBalancer;

import org.apache.shardingsphere.infra.context.transaction.TransactionConnectionContext;
import org.apache.shardingsphere.readwritesplitting.spi.ReadQueryLoadBalanceAlgorithm;

import java.util.List;

public class CustomHashLoadBalancer implements ReadQueryLoadBalanceAlgorithm {

    private Integer currentIndex = -1;

    @Override
    public String getType() {
        return "CUSTOM_READ_BALANCER";
    }

    @Override
    public String getDataSource(String slaveDatasource, String masterDatasource, List<String> replicaList,
                                TransactionConnectionContext transactionConnectionContext) {

        currentIndex = (currentIndex + 1) % replicaList.size();
        return replicaList.get(currentIndex);
    }

}