package com.cleverpine.viravabackendcommon.dto;

import com.cleverpine.viravabackendcommon.annotation.Default;

import java.util.*;

public class User {

    private final long id;
    private String username;
    private final Map<String, String> data;
    private final Set<Permission> permissions;
    private ResourcePermissions resourcePermissions;

    public User(long id, String username) {
        this.id = id;
        setUsername(username);
        this.data = new HashMap<>();
        this.permissions = new HashSet<>();
    }

    @Default
    public User(long id, String username, Map<String, String> data, Set<Permission> permissions,
                ResourcePermissions resourcePermissions) {
        this.id = id;
        setUsername(username);
        this.data = data == null ? new HashMap<>() : new HashMap<>(data);
        this.permissions = permissions == null ? new HashSet<>() : new HashSet<>(permissions);
        this.resourcePermissions = resourcePermissions;
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().length() == 0) {
            throw new IllegalArgumentException("Cannot create user with empty username!");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, String> getData() {
        return Map.copyOf(data);
    }

    public Set<Permission> getPermissions() {
        return Set.copyOf(permissions);
    }

    public boolean hasPermission(String permission) {
        if (permission == null) {
            return false;
        }
        return permissions.stream()
                .map(Permission::getName)
                .anyMatch(permission::equals);
    }

    public ResourcePermissions getResourcePermissions() {
        return resourcePermissions;
    }

    public ResourcePermission getResourcePermission(String resource) {
        if (resource == null || resourcePermissions == null) {
            return null;
        }
        return resourcePermissions.getResourcePermission(resource);
    }

    public void addData(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        data.put(key, value);
    }

    public void removeData(String key) {
        if (key == null) {
            return;
        }
        data.remove(key);
    }

    public void addPermission(Permission permission) {
        if (permission == null) {
            return;
        }
        permissions.add(permission);
    }

    public void addPermissions(Collection<Permission> permissions) {
        if (permissions == null || permissions.isEmpty()) {
            return;
        }
        this.permissions.addAll(permissions);
    }

    public void removePermission(Permission permission) {
        if (permission == null) {
            return;
        }
        permissions.remove(permission);
    }

    public void removePermissions(Collection<Permission> permissions) {
        if (permissions == null || permissions.isEmpty()) {
            return;
        }
        this.permissions.removeAll(permissions);
    }
}
