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
}