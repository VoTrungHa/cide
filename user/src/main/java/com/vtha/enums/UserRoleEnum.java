package com.vtha.enums;

public enum UserRoleEnum {
    ADMIN("ADMIN"),
    USER("USER");

    private String identify;

    UserRoleEnum(String identify) {
        this.identify = identify;
    }

    public String getIdentify() {
        return identify;
    }
}
