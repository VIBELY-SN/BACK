package com.metrica.vibely.data.util;

@FunctionalInterface
public interface Copyable<Entity> {

    /**
     * Performs a deep copy of the given Entity
     *
     * @return a deep copy of the given entity
     */
    Entity deepCopy();

}