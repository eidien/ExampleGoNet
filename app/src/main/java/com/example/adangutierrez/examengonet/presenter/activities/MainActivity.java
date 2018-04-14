package com.example.adangutierrez.examengonet.presenter.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.data.model.Marcas;
import com.example.adangutierrez.examengonet.presenter.bases.BaseActivity;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitializeUI() {
        setToolbar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.answer_logout)
                .setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        logoutFinished();
                    }
                })
                .setNegativeButton(R.string.button_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        builder.create();
        builder.show();
    }

    private void logoutFinished() {
        Realm mRealm = null;
        try {
            mRealm = Realm.getDefaultInstance();
            RealmResults<Marcas> result = mRealm.where(Marcas.class).findAll();
            if (result == null && result.size() > 0) {
                result.deleteAllFromRealm();
            }
        } finally {
            if (mRealm != null) {
                mRealm.close();
            }
        }

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
