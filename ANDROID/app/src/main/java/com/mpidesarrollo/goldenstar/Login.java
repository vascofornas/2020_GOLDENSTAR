package com.mpidesarrollo.goldenstar;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("body")
    private  String access_topken;
    private String token_type;
    private Integer expires_in;
    private String twoFactory;
    private String issued;
    private String expires;


    public String getAccess_topken() {
        return access_topken;
    }

    public String getToken_type() {
        return token_type;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public String getTwoFactory() {
        return twoFactory;
    }

    public String getIssued() {
        return issued;
    }

    public String getExpires() {
        return expires;
    }
}
