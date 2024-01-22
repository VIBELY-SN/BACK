package com.metrica.vibely.data.util;

import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

public class DeepCopyGeneratorTest {

    @Test
    void tryToCopy() {
        Set<User> users = Set.of(
                new User(),
                new User());

        assertEquals(users, DeepCopyGenerator.generateCopy(users));
    }


}

