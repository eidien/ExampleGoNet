package com.example.adangutierrez.examengonet.presenter.fragments;

import android.content.Intent;
import android.os.CountDownTimer;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.presenter.activities.LoginActivity;
import com.example.adangutierrez.examengonet.presenter.activities.MainActivity;
import com.example.adangutierrez.examengonet.presenter.bases.BaseFragment;
import com.example.adangutierrez.examengonet.presenter.utils.SharedKeys;
import com.example.adangutierrez.examengonet.presenter.utils.SharedPreferencesManager;

public class SplashFragment extends BaseFragment {

    private final int SPLASH_DISPLAY_LENGTH = 5 * 1000;
    private CountDownTimer mTimer;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void onInitializeUI() {
        mTimer = new CountDownTimer(SPLASH_DISPLAY_LENGTH, SPLASH_DISPLAY_LENGTH) {
            public void onTick(long millisUntilFinished) { }

            public void onFinish() {
                boolean isLogin = SharedPreferencesManager.getSharedPreferenceAs(boolean.class, SharedKeys.LOGIN, false);
                Intent intent = new Intent(getActivity(), isLogin ? MainActivity.class : LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                getActivity().startActivity(intent);
            }
        };
        mTimer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTimer != null) mTimer.cancel();
    }
}
