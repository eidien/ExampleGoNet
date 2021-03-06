package com.example.adangutierrez.examengonet.presenter.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.adangutierrez.examengonet.presenter.widgets.CustomDialogProgressIndicator;

import butterknife.ButterKnife;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CustomDialogProgressIndicator mProgressIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mProgressIndicator = new CustomDialogProgressIndicator(this);
        onInitializeUI();
    }

    public void setToolbar(Toolbar mToolbar) {
        this.mToolbar = mToolbar;
        setSupportActionBar(mToolbar);
    }

    public void setTitleToolbar(int message) {
        setTitle(message);
    }

    public abstract int getLayoutId();

    protected abstract void onInitializeUI();

    public void showProgressBar() {
        if (mProgressIndicator != null && !mProgressIndicator.isShowing())
            mProgressIndicator.show();
    }

    public void dismissProgressBar() {
        if (mProgressIndicator != null && mProgressIndicator.isShowing())
            mProgressIndicator.dismiss();
    }
}
