package models;

import java.util.*;

public class Task {

    int id;
    int ownerId;
    String description;
    String createdAt;

    //Test databases
    private static Set<Task> taskTestCollection;

    static {
        taskTestCollection = new HashSet();
        taskTestCollection.add(new Task(1, 1, "Getting Married"));
        taskTestCollection.add(new Task(2, 1, "Go to bed"));
    }

    public Task() {}

    public Task(int ownerId, String description) {
        this.ownerId = ownerId;
        this.description = description;
    }

    public Task(int id, int ownerId, String description) {
        this.id = id;
        this.ownerId = ownerId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() { return createdAt; }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
