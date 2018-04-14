package com.example.adangutierrez.examengonet.domain.interactors.login;

import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(ResponseLogin responseLogin);

        void onError(Throwable throwable);
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
