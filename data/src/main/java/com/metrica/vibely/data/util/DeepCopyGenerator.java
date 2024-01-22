package com.metrica.vibely.data.util;

import java.util.Set;
import java.util.stream.Collectors;

public class DeepCopyGenerator {

    // <<-CONSTRUCTOR->>
    private DeepCopyGenerator() {
    }

    // <<-METHOD->>
    public static <T extends Copyable<T>> Set<T> generateCopy(Set<T> collection) {
        return collection.stream()
                .map(T::deepCopy)
                .collect(Collectors.toSet());
    }

}
