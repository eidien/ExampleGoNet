package com.example.adangutierrez.examengonet;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.example.adangutierrez.examengonet.presenter.utils.SharedPreferencesManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class App extends MultiDexApplication {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        SharedPreferencesManager.init(this)
                .setSharedPreferencesName(getString(R.string.app_name));

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(getString(R.string.app_name) + ".realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public static Context getContext() {
        return context;
    }
}
