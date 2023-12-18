package com.metrica.vibely.data.util;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

import com.metrica.vibely.data.exception.ExpiredApiKeyException;
import com.metrica.vibely.data.exception.InvalidFormatException;
import com.metrica.vibely.data.model.enumerator.HttpStatusEnum;

public class ApiKeyManager {

    // <<-CONSTANTS->>
    private static final int KEY_SIZE_BYTES = 32;
    private static final int LONG_SIZE_BYTES = Long.BYTES;
    private static final int UUID_SIZE_BYTES = 36;

    // <<-CONSTRUCTOR->>
    private ApiKeyManager() {
    }

    // <<-METHODS->>
    /**
     * Generates a random API key using a secure random number generator.
     *
     * @return a randomly generated API key as a Base64-encoded string.
     */
    public static String generate(UUID id) {
        byte[] keyBytes = new byte[KEY_SIZE_BYTES];
        new SecureRandom().nextBytes(keyBytes);

        // Get current time and set expiration time (1hour)
        long currentTime = Instant.now().getEpochSecond();
        long expirationTime = currentTime + 3600;

        ByteBuffer buffer = ByteBuffer.allocate(KEY_SIZE_BYTES + UUID_SIZE_BYTES + LONG_SIZE_BYTES);
        buffer.put(keyBytes);
        byte[] uuidBytes = id.toString().getBytes();
        buffer.put(uuidBytes);
        buffer.putLong(expirationTime);

        byte[] concatenated = buffer.array();

        return Base64.getEncoder().encodeToString(concatenated);
    }
}