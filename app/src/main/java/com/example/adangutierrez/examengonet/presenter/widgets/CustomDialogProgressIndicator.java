package com.example.adangutierrez.examengonet.presenter.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.adangutierrez.examengonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class CustomDialogProgressIndicator extends Dialog {

    @BindView(R.id.progres)
    ProgressBar mProgressBar;

    private Context mContext;

    public CustomDialogProgressIndicator(Context mContext) {
        super(mContext, R.style.Theme_Transparent);
        this.mContext = mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_progress_dialog);
        setCancelable(false);
        ButterKnife.bind(this);
    }
}

