package com.example.adangutierrez.examengonet.presenter.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class SharedPreferencesManager {

    private static final String TAG = SharedPreferencesManager.class.getSimpleName();

    private static SharedSettings sharedSettings;

    public static SharedSettings init(@NonNull Context context) {
        sharedSettings = new SharedSettings();
        return sharedSettings.setContext(context);
    }

    public static SharedSettings getSettings() {
        return sharedSettings;
    }

    public static <T> T getSharedPreferenceAs(Class<T> classType, String key, T defaultValue) {
        try {
            if(getSettings() != null) {
                return getSettings().getSettingFromJson(key, classType, defaultValue);
            }
        } catch (Exception exception) {
            Log.e(TAG, "Get Shared Preference: " + exception.getMessage());
            return defaultValue;
        }

        return null;
    }

    public static <T> boolean setSharedPreferenceAs(String key, T data, boolean replaceIfExist) {
        try {
            if(getSettings() != null) {
                getSettings().setSettingToJson(key, data, replaceIfExist);
                return true;
            }
        } catch (Exception exception) {
            Log.e(TAG, "Set Shared Preference: " + exception.getMessage());
            return false;
        }

        return false;
    }

    public static <T> boolean setSharedPreferenceAsArrayList(String key,
                                                             ArrayList<T> data,
                                                             Type sourceType,
                                                             boolean replaceIfExist) {
        try {
            if(getSettings() != null) {
                getSettings().setSettingToJsonType(key, data, sourceType, replaceIfExist);
                return true;
            }
        } catch (Exception exception) {
            Log.e(TAG, "Set Shared Preference: " + exception.getMessage());
            return false;
        }

        return false;
    }

    public static <T> ArrayList<T> getSharedPreferenceAsArrayList(String key,
                                                                  Type sourceType,
                                                                  ArrayList<T> defaultValue) {
        try {
            if(getSettings() != null) {
                return getSettings().getSettingFromJson(key, sourceType, defaultValue);
            }
        } catch (Exception exception) {
            Log.e(TAG, "Get Shared Preference: " + exception.getMessage());
            return defaultValue;
        }

        return null;
    }

    public static <T> boolean deleteSharedPreference(String key) {
        try {
            if(getSettings() != null) {
                return getSettings().deleteSetting(key);
            }
        } catch (Exception exception) {
            Log.e(TAG, "Delete Shared Preference: " + exception.getMessage());
            return false;
        }

        return false;
    }
}
