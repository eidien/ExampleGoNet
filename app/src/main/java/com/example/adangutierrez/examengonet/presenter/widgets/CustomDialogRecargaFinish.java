package com.example.adangutierrez.examengonet.presenter.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.adangutierrez.examengonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class CustomDialogRecargaFinish extends Dialog {

    @BindView(R.id.btn_finish)
    Button buttonAceptar;

    private Context mContext;
    private View.OnClickListener mListener;

    public CustomDialogRecargaFinish(Context mContext, View.OnClickListener mListener) {
        super(mContext, R.style.Theme_Transparent);
        this.mContext = mContext;
        this.mListener = mListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_recarga_finish);
        setCancelable(false);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_finish)
    public void onClickAceptar(){
        mListener.onClick(buttonAceptar);
        dismiss();
    }
}

