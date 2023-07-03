package com.cleverpine.viravabackendcommon.dto;

import com.cleverpine.viravabackendcommon.annotation.Default;

public class Resource {

    private final long id;
    private final String name;
    private final String displayName;

    public Resource(long id, String name) {
        validateName(name);
        this.id = id;
        this.name = name;
        this.displayName = name;
    }

    @Default
    public Resource(long id, String name, String displayName) {
        validateName(name);
        validateDisplayName(displayName);
        this.id = id;
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    private void validateName(String name) {
        validateName(name, "name");
    }

    private void validateDisplayName(String displayName) {
        validateName(displayName, "displayName");
    }

    private void validateName(String name, String identifier) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException(String.format("Cannot create resource with empty %s!", identifier));
        }
    }
}
