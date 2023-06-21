package com.cleverpine.viravabackendcommon.dto;

import com.cleverpine.viravabackendcommon.annotation.Default;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResourcePermission {

    private boolean all;
    private final Set<String> ids;

    public ResourcePermission() {
        this.ids = new HashSet<>();
    }

    @Default
    public ResourcePermission(boolean all, Set<String> ids) {
        this.all = all;
        this.ids = ids == null ? new HashSet<>() : new HashSet<>(ids);
    }

    public boolean isAll() {
        return all;
    }

    public void setAll(boolean all) {
        this.all = all;
    }

    public Set<String> getIds() {
        return Set.copyOf(ids);
    }

    public List<Long> getIdsAsLong() {
        return ids.stream()
                .map(Long::parseLong)
                .toList();
    }

    public void addId(String id) {
        if (id == null) {
            return;
        }
        ids.add(id);
    }

    public void addIds(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        this.ids.addAll(ids);
    }

    public void removeId(String id) {
        if (id == null) {
            return;
        }
        ids.remove(id);
    }

    public void removeIds(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        this.ids.removeAll(ids);
    }
}
