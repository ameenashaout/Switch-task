package com.example.demo.security;

public enum ApplicationUserPermission {
    DRIVERS_READ("driver:read"),
    DRIVERS_WRITE("driver:write");


    private  String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
