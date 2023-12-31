package kr.ac.mjc.product.dto;

import kr.ac.mjc.product.domain.User;

public class UserResponse {

    private boolean success;

    private String message;

    public UserResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private User user;

    public UserResponse() {

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}