package com.example.adangutierrez.examengonet.presenter.fragments;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.presenter.bases.BaseFragment;
import com.example.adangutierrez.examengonet.presenter.widgets.CustomDialogRecarga;
import com.example.adangutierrez.examengonet.presenter.widgets.CustomDialogRecargaFinish;

import butterknife.BindView;
import butterknife.OnClick;

public class RecargaFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.et_telefono)
    EditText editTextTelefono;

    @BindView(R.id.et_monto)
    EditText editTextMonto;

    private CustomDialogRecarga dialogRecarga;
    private CustomDialogRecargaFinish customDialogRecargaFinish;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recarga;
    }

    @Override
    protected void onInitializeUI() {
        customDialogRecargaFinish= new CustomDialogRecargaFinish(getActivity(), this);
    }

    @OnClick(R.id.btn_recargar)
    public void onClickRecargar() {
        if (validaData()) {
            dialogRecarga = new CustomDialogRecarga(getActivity(), editTextTelefono.getText().toString(), editTextMonto.getText().toString(), this);
            dialogRecarga.setCancelable(false);
            dialogRecarga.show();
        }
    }

    private boolean validaData() {

        String tel = editTextTelefono.getText().toString();
        String monto = editTextMonto.getText().toString();

        if (tel.trim().isEmpty()) {
            editTextTelefono.setError("Proporcione un número");
            return false;
        } else if (tel.length() < 10) {
            editTextTelefono.setError("El número no es válido");
            return false;
        } else if (monto.trim().isEmpty()) {
            editTextMonto.setError("Proporcione el monto");
            return false;
        } else if (Integer.parseInt(monto)  < 3 && Integer.parseInt(monto) > 100) {
            editTextMonto.setError("El monto debe de estar entre 3 y 100");
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_aceptar) {
            showProgressBar();
            new CountDownTimer(3000, 3000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    dismissProgressBar();
                    customDialogRecargaFinish.show();
                }
            }.start();
        }

        if (view.getId() == R.id.btn_finish) {
            getActivity().finish();
        }
    }
}
