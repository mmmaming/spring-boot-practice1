package com.example.demo;

public class UpdateRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateRequest{" +
                "id=" + id +
                '}';
    }
}
