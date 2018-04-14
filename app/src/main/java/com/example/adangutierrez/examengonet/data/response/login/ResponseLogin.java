package com.example.adangutierrez.examengonet.data.response.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class ResponseLogin {

    @SerializedName("agente")
    @Expose
    private String agente;
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("token")
    @Expose
    private String token;

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
