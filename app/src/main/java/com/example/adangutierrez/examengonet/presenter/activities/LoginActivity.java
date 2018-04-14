package com.example.adangutierrez.examengonet.presenter.activities;

import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.presenter.bases.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitializeUI() {
        setToolbar(mToolbar);
        setTitle(R.string.nothing);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
}
