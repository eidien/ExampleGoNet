package com.example.adangutierrez.examengonet.presenter.activities;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.presenter.bases.BaseActivity;

import butterknife.BindView;

public class RecargaActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recarga;
    }

    @Override
    protected void onInitializeUI() {
        setToolbar(mToolbar);
        setTitle(R.string.title_recarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
