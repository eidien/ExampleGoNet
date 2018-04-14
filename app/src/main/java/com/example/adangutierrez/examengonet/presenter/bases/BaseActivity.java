package com.example.adangutierrez.examengonet.presenter.bases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
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
}
