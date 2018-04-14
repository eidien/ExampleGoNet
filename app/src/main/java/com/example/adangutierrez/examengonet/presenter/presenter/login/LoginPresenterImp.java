package com.example.adangutierrez.examengonet.presenter.presenter.login;

import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;
import com.example.adangutierrez.examengonet.domain.interactors.login.LoginInteractor;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class LoginPresenterImp implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImp(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.onShowProgress(true);
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.onShowProgress(false);
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.onShowProgress(false);
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess(ResponseLogin responseLogin) {
        if (loginView != null) {
            loginView.onShowProgress(false);
            if (responseLogin != null && responseLogin.getError() == null) {
                loginView.navigateToHome(responseLogin);
            } else {
                loginView.onError(new Throwable(responseLogin.getError().getMessage()));
            }
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if (loginView != null) {
            loginView.onShowProgress(false);
            loginView.onError(throwable);
        }
    }
}
