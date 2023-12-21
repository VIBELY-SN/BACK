package com.metrica.vibely.data.mapper;

import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Admin;
import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.AdminDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.data.model.enumerator.UserStatus;
import com.metrica.vibely.data.model.mapper.AdminMapper;
import com.metrica.vibely.data.model.mapper.UserMapper;

import org.junit.jupiter.api.Tag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AdminMapperTest {

    // <<-CONSTANTS->>
    private static final UUID ADMIN_ID = UUID.randomUUID();
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminPass";
    private static final String ADMIN_NICKNAME = "Admin Nick";
    private static final String ADMIN_EMAIL = "admin@example.com";
    private static final String ADMIN_APIKEY = "adminApikey";
    private static final UserState ADMIN_STATE = UserState.ENABLED;
    private static final PrivacyType ADMIN_PRIVACY = PrivacyType.PRIVATE;
    private static final UserStatus ADMIN_STATUS = UserStatus.ONLINE;
    private static final Integer ADMIN_LOGINS = 1;
    private static final LocalDateTime ADMIN_LAST_CONN_DATE = LocalDateTime.now();
    private static final LocalDate ADMIN_BLOCKED_DATE = LocalDate.now();
