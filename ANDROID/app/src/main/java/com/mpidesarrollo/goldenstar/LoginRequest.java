package com.mpidesarrollo.goldenstar;

public class LoginRequest {

    private String username;
    private String password;
    private String grant_type;
    private String latitude;
    private String longitude;

    public LoginRequest(String username, String password, String grant_type, String latitude, String longitude) {
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
