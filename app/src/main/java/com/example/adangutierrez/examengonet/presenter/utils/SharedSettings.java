package com.example.adangutierrez.examengonet.presenter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class SharedSettings {

    private static final String TAG = SharedSettings.class.getName();
    private Context context;
    private SharedPreferences sharedPreferences;

    private Gson gson;

    public Context getContext() {
        return context;
    }

    private SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedSettings setContext(Context context) {
        this.context = context;
        gson = new Gson();
        return this;
    }

    public SharedSettings setSharedPreferencesName(String name) {
        sharedPreferences = getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
        return this;
    }

    public boolean settingExist(String key) {
        boolean exist;

        try {
            exist = getSharedPreferences().contains(key);
        } catch (Exception exception) {
            Log.e(TAG, Log.getStackTraceString(exception));
            exist = false;
        }

        return  exist;
    }

    public String getSetting(String key, String otherwise) {
        return getSharedPreferences().getString(key, otherwise);
    }

    public void setSetting(String key, String data, boolean replaceIfExist) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();

        if(replaceIfExist) {
            editor.putString(key, data);
            editor.commit();
        }
        else {
            if(!settingExist(key)) {
                editor.putString(key, data);
                editor.commit();
            }
        }
    }

    public Boolean getSettingBoolean(String key, Boolean otherwise) {
        return getSharedPreferences().getBoolean(key, otherwise);
    }

    public void setSettingBoolean(String key, Boolean data, boolean replaceIfExist) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();

        if(replaceIfExist) {
            editor.putBoolean(key, data);
            editor.commit();
        } else {
            if(!settingExist(key)) {
                editor.putBoolean(key, data);
                editor.commit();
            }
        }
    }

    public boolean deleteSetting(String key) {
        try {
            SharedPreferences.Editor editor = getSharedPreferences().edit();
            return editor.remove(key).commit();
        } catch (Exception ex) {
            Log.e(TAG, Log.getStackTraceString(ex));
            return false;
        }
    }

    public <T> T getSettingFromJson(String key, Class<T> typeClass, T otherwise) {
        T setting;

        if(settingExist(key)) {
            String jsonPreference = getSetting(key, null);
            setting = deserialize(jsonPreference, typeClass);
        }
        else {
            setting = otherwise;
        }

        return setting;
    }

    public <T> ArrayList<T> getSettingFromJson(String key, Type sourceType, ArrayList<T> otherwise) {
        ArrayList<T> setting;

        if(settingExist(key)) {
            String jsonPreference = getSetting(key, null);
            setting = deserialize(jsonPreference, sourceType);
        }
        else {
            setting = otherwise;
        }

        return setting;
    }

    public <T> void setSettingToJson(String key, T data, boolean replaceIfExist) {
        String json = serialize(data);
        setSetting(key, json, replaceIfExist);
    }

    public <T> void setSettingToJsonType(String key, T data, Type sourceType, boolean replaceIfExist) {
        String json = serializeType(data, sourceType);
        setSetting(key, json, replaceIfExist);
    }

    public <T> String serialize(T data) {
        String json;

        try {
            json = gson.toJson(data);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            json = null;
        }

        return json;
    }

    public <T> String serializeType(T data, Type sourceType) {
        String json;

        try {
            json = gson.toJson(data, sourceType);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            json = null;
        }

        return json;
    }

    public <T> T deserialize(String json, Class<T> typeClass) {
        T data;

        try {
            data = gson.fromJson(json, typeClass);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            data = null;
        }

        return data;
    }

    public <T> T deserialize(String json, Type type) {
        T data;

        try {
            data = gson.fromJson(json, type);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, Log.getStackTraceString(e));
            data = null;
        }

        return data;
    }
}
