package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;

    public LocalDateTime getUpdateAl() {
        return updateAl;
    }

    public void setUpdateAl(LocalDateTime updateAl) {
        this.updateAl = updateAl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private LocalDateTime updateAl;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updateAl=" + updateAl +
                '}';
    }
}
