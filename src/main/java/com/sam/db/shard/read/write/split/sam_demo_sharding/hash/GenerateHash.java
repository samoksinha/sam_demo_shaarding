package com.sam.db.shard.read.write.split.sam_demo_sharding.hash;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Component
public class GenerateHash extends HashUtil {

    public final MessageDigest digest;

    public final String appName;

    public GenerateHash(
            @Value("${spring.application.name}")
            String appName) throws NoSuchAlgorithmException {

        this.digest = MessageDigest.getInstance("SHA-256");
        this.appName = appName;
    }

    public String generateUserIdHash(String userId) {

        StringBuilder userIdBuilder = new StringBuilder();
        userIdBuilder
                .append(userId)
                .append(":")
                .append(this.appName);

        return generateHash(digest, userIdBuilder.toString());
    }

    public String generateOrderIdHash(String userId, LocalDateTime timestamp) {

        StringBuilder orderIdBuilder = new StringBuilder();
        orderIdBuilder
                .append(userId)
                .append(":")
                .append(timestamp)
                .append(":")
                .append(this.appName);

        return generateHash(digest, orderIdBuilder.toString());
    }

    public String generateItemIdHash(String itemId, LocalDateTime timestamp) {

        StringBuilder itemIdBuilder = new StringBuilder();
        itemIdBuilder
                .append(itemId)
                .append(":")
                .append(timestamp)
                .append(":")
                .append(this.appName);

        return generateHash(digest, itemIdBuilder.toString());
    }

    public String generateOrderItemIdHash(String orderId, String itemId, LocalDateTime timestamp) {

        StringBuilder orderItemIdBuilder = new StringBuilder();
        orderItemIdBuilder
                .append(orderId)
                .append(":")
                .append(timestamp)
                .append(":")
                .append(itemId);

        return generateHash(digest, orderItemIdBuilder.toString());
    }

    public BigInteger getBigIntegerFromHash(String generatedHash) {
        return base62ToBigInteger(generatedHash);
    }

}
