package com.example.adangutierrez.examengonet.presenter.widgets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.adangutierrez.examengonet.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class CustomDialogRecarga extends Dialog {

    @BindView(R.id.tv_hora)
    TextView textViewHora;

    @BindView(R.id.tv_date)
    TextView textViewDia;

    @BindView(R.id.tv_telefono)
    TextView textViewTelefono;

    @BindView(R.id.tv_monto)
    TextView textViewMonto;

    @BindView(R.id.btn_aceptar)
    Button buttonAceptar;

    private Context mContext;
    private String numero;
    private String monto;
    private View.OnClickListener mListener;

    public CustomDialogRecarga(Context mContext, String numero, String monto, View.OnClickListener mListener) {
        super(mContext, R.style.Theme_Transparent);
        this.mContext = mContext;
        this.numero = numero;
        this.monto = monto;
        this.mListener = mListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_recarga);
        setCancelable(false);
        ButterKnife.bind(this);

        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy");

        Calendar calendar = Calendar.getInstance();

        textViewHora.setText(hour.format(calendar.getTime()));
        textViewDia.setText(date.format(calendar.getTime()));

        textViewTelefono.setText(numero);
        textViewMonto.setText("$" + monto + ".00");
    }

    @OnClick(R.id.btn_cancelar)
    public void onClickCancelar() {
        dismiss();
    }

    @OnClick(R.id.btn_aceptar)
    public void onClickAceptar(){
        mListener.onClick(buttonAceptar);
        dismiss();
    }
}

