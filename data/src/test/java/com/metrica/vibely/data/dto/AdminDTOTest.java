package com.metrica.vibely.data.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Admin;
import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.AdminDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.data.model.enumerator.UserStatus;

/**
 * <h1>Admin DTO Test</h1>
 *
 * @since 2023-11-20
 * @version 1.0
 * @author Adri
 */
class AdminDTOTest {

    // <<-CONSTANTS->>
    private static final String USERNAME = "jdoe";
    private static final String PASSWORD = "12345";
    private static final String NICKNAME = "John Doe";
    private static final String EMAIL = "johndoe@email.com";
    private static final String APIKEY = "randomApikey";
    private static final UserState STATE = UserState.ENABLED;
    private static final PrivacyType PRIVACY = PrivacyType.PUBLIC;
    private static final UserStatus STATUS = UserStatus.ONLINE;
    private static final Integer LOGINS = 0;
    private static final LocalDateTime LAST_CONN_DATE = LocalDateTime.now();
    private static final LocalDate BLOCKED_DATE = LocalDate.now();
}
