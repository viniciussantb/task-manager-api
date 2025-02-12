package com.example.taskManager.model;

import java.util.Date;

import jakarta.persistence.*;

import com.example.taskManager.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Task {

    @Id
    @JsonProperty(value = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(value = "title")
    @Column(name = "title")
    private String title;

    @JsonProperty(value = "description")
    @Column(name = "description")
    private String description;

    @JsonProperty(value = "dueDate")
    @Column(name = "dueDate")
    private long dueDate;

    @JsonProperty(value = "status")
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
