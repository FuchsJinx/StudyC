package com.karpeko.c.ui.dashboard;

import java.util.StringTokenizer;

public class Task {
    private int id;
    private String title;
    private boolean completed;

    public Task(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isComplete() { return completed; }
    public void setComplete(boolean complete) { this.completed = complete; }
}
