package com.cleverpine.viravabackendcommon.dto;

import com.cleverpine.viravabackendcommon.annotation.Default;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResourcePermissions {

    private final Map<String, ResourcePermission> resourcePermissionMap;

    public ResourcePermissions() {
        this.resourcePermissionMap = new HashMap<>();
    }

    @Default
    public ResourcePermissions(Map<String, ResourcePermission> resourcePermissionMap) {
        this.resourcePermissionMap = resourcePermissionMap == null ? new HashMap<>() : new HashMap<>(resourcePermissionMap);
    }

    public Map<String, ResourcePermission> getResourcePermissionMap() {
        return Map.copyOf(resourcePermissionMap);
    }

    public void addResourcePermission(String resource, ResourcePermission resourcePermission) {
        if (resource == null || resourcePermission == null) {
            return;
        }
        resourcePermissionMap.put(resource, resourcePermission);
    }

    public void removeResourcePermission(String resource) {
        if (resource == null) {
            return;
        }
        resourcePermissionMap.remove(resource);
    }

    public ResourcePermission getResourcePermission(String resource) {
        return Optional.ofNullable(resource)
                .map(resourcePermissionMap::get)
                .orElse(null);
    }
}
