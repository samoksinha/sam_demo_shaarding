package com.sam.db.shard.read.write.split.sam_demo_sharding.hash;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashUtil {

    public static final Integer HASH_LENGTH = 20;

    private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Generates a hash from a value using the provided MessageDigest instance.
     *
     * This method converts the value to a byte array using UTF-8 encoding, then hashes the byte array.
     * The hash is then converted to a positive BigInteger and encoded in base62.
     *
     * The resulting base62-encoded string is truncated to the desired length.
     * If the encoded string is shorter than the desired length, it is padded with leading zeros.
     *
     * Finally, the base62-encoded hash is returned as a string.
     *
     * @param digest the MessageDigest instance to use.
     * @param valueToBeHashed the value to hash.
     * @return the hash as a base62-encoded string.
     */
    public String generateHash(MessageDigest digest, String valueToBeHashed) {

        byte[] hashBytes = digest.digest(
                valueToBeHashed.getBytes(StandardCharsets.UTF_8));

        // Convert the byte array to a positive BigInteger.
        BigInteger hashInt = new BigInteger(1, hashBytes);
        // Encode the BigInteger in base62.
        String base62Hash = base62Encode(hashInt);

        // Truncate to the desired length. (Alternatively, pad if needed.)
        if (base62Hash.length() >= HASH_LENGTH) {
            return base62Hash.substring(0, HASH_LENGTH);
        } else {
            // Pad with leading zeros if the encoded string is too short.
            return String.format("%1$" + HASH_LENGTH + "s", base62Hash).replace(' ', '0');
        }
    }

    /**
     * Encodes a BigInteger value in base62.
     *
     * This method uses the BASE62 string to encode the value.
     * Create a StringBuilder to store the encoded string.
     * Create a BigInteger base to represent the base (62).
     *
     * While the value is greater than zero:
     * - Divide the value by the base and get the quotient and remainder.
     * - The remainder is the digit to append to the StringBuilder.
     * - Update the value to the quotient.
     * - Repeat until the value is zero.
     *
     * Reverse the StringBuilder and return the base62-encoded string.
     *
     * @param value the BigInteger value to encode.
     * @return the base62-encoded string.
     */
    private String base62Encode(BigInteger value) {
        StringBuilder sb = new StringBuilder();
        BigInteger base = BigInteger.valueOf(62);

        // Convert value to base62.
        while (value.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divRem = value.divideAndRemainder(base);
            int digit = divRem[1].intValue();
            sb.append(BASE62.charAt(digit));
            value = divRem[0];
        }

        return sb.reverse().toString();
    }

    /**
     * Converts a base62 encoded string to a BigInteger.
     *
     * Create a BigInteger result initialized to zero.
     * Create a BigInteger base to represent the base (62).
     *
     * For each character in the base62 string:
     * - Get the index of the character in the BASE62 string.
     * - If the character is not found, throw an IllegalArgumentException.
     * - Multiply the result by the base and add the digit value.
     *
     * Return the resulting BigInteger.
     *
     * @param base62Str the base62 string to convert.
     * @return the corresponding BigInteger.
     */
    public BigInteger base62ToBigInteger(String base62Str) {

        BigInteger result = BigInteger.ZERO;
        BigInteger base = BigInteger.valueOf(62);
        for (int i = 0; i < base62Str.length(); i++) {
            int digit = BASE62.indexOf(base62Str.charAt(i));
            if (digit == -1) {
                throw new IllegalArgumentException("Invalid character in base62 string: " + base62Str.charAt(i));
            }
            result = result.multiply(base).add(BigInteger.valueOf(digit));
        }

        return result;
    }

}
