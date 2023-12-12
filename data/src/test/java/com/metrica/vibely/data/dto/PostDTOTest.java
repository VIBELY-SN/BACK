package com.metrica.vibely.data.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.model.dto.PostDTO;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;

class PostDTOTest {

    // <<-CONSTANTS->>
    private static final LocalDateTime POST_DATE = LocalDateTime.now();
    private static final PostStatus STATUS = PostStatus.ACTIVE;
    private static final PostVisibility VISIBILITY = PostVisibility.PUBLIC;
    private static final String CONTENT = "content";
    private static final Integer ZERO = 0;
}