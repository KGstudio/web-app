package com.kgs.webapp;

public class User {
    private int userId;
    private String family;

    // Конструкторы, геттеры и сеттеры
    public User(int userId, String family) {
        this.userId = userId;
        this.family = family;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
