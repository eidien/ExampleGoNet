package com.example.adangutierrez.examengonet.presenter.presenter.login;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
