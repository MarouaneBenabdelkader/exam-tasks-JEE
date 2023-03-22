package com.example.examtasks.models;

public class Task {
    private String  content;
    private Integer id;

    public Task(String content, Integer id) {
        this.content = content;
        this.id = id;
    }

    public Task() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
