package com.cleverpine.viravabackendcommon.dto;

public class Resource {

    private final long id;
    private final String name;

    public Resource(long id, String name) {
        validateName(name);
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot create resource with empty name!");
        }
    }
}
