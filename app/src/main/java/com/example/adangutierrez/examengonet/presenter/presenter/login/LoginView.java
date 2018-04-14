package com.example.adangutierrez.examengonet.presenter.presenter.login;

import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public interface LoginView {

    void onShowProgress(boolean isShowing);

    void setUsernameError();

    void setPasswordError();

    void navigateToHome(ResponseLogin responseLogin);

    void onError(Throwable throwable);
}
