package com.example.adangutierrez.examengonet.domain.interactors.login;

import android.text.TextUtils;

import com.example.adangutierrez.examengonet.data.request.login.Data;
import com.example.adangutierrez.examengonet.data.request.login.RequestLogin;
import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;
import com.example.adangutierrez.examengonet.domain.net.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class LoginInteractorImp implements LoginInteractor {

    @Override
    public void login(String username, String password, final OnLoginFinishedListener listener) {
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            return;
        }

        Data data = new Data(username, password);
        RequestLogin requestLogin = new RequestLogin(data);
        Call<ResponseLogin> call = RetrofitApi.getInstance().doLogin(
                "Android",
                "2.5.2",
                requestLogin);

        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError(new Throwable("Ah ocurrido un error inesperado"));
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                listener.onError(t);
            }
        });
    }
}
