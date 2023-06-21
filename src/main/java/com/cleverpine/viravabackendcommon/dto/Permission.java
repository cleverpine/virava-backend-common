package com.cleverpine.viravabackendcommon.dto;

public class Permission {
    private final long id;
    private final String name;

    public Permission(long id, String name) {
        this.id = id;
        validateName(name);
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot create permission with empty name!");
        }
    }
}
