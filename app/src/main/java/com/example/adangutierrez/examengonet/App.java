package com.example.adangutierrez.examengonet;

import android.support.multidex.MultiDexApplication;

import com.example.adangutierrez.examengonet.presenter.utils.SharedPreferencesManager;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesManager.init(this)
                .setSharedPreferencesName(getString(R.string.app_name));
    }
}
