package com.example.adangutierrez.examengonet.presenter.fragments;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.data.model.Marcas;
import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;
import com.example.adangutierrez.examengonet.domain.interactors.login.LoginInteractorImp;
import com.example.adangutierrez.examengonet.presenter.activities.MainActivity;
import com.example.adangutierrez.examengonet.presenter.bases.BaseFragment;
import com.example.adangutierrez.examengonet.presenter.presenter.login.LoginPresenter;
import com.example.adangutierrez.examengonet.presenter.presenter.login.LoginPresenterImp;
import com.example.adangutierrez.examengonet.presenter.presenter.login.LoginView;
import com.example.adangutierrez.examengonet.presenter.utils.GeneralUtils;
import com.example.adangutierrez.examengonet.presenter.utils.SharedKeys;
import com.example.adangutierrez.examengonet.presenter.utils.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;

public class LoginFragment extends BaseFragment implements LoginView {

    @BindView(R.id.et_user)
    EditText editTextUser;

    @BindView(R.id.et_pass)
    EditText editTextPass;

    private LoginPresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void onInitializeUI() {
        presenter = new LoginPresenterImp(this, new LoginInteractorImp());
    }

    @Override
    public void onShowProgress(boolean isShowing) {
        if (isShowing) showProgressBar(); else dismissProgressBar();
    }

    @Override
    public void setUsernameError() {
        editTextUser.setError(getString(R.string.error_user_empty));
    }

    @Override
    public void setPasswordError() {
        editTextPass.setError(getString(R.string.error_pass_empty));
    }

    @Override
    public void navigateToHome(ResponseLogin responseLogin) {

        final List<Marcas> marcasArrayList = new ArrayList<>(GeneralUtils.getDefaultInfo());
        Realm mRealm = null;
        try {
            mRealm = Realm.getDefaultInstance();
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    RealmList<Marcas> _newsList = new RealmList<>();
                    _newsList.addAll(marcasArrayList);
                    realm.insertOrUpdate(_newsList);
                }
            });
        } finally {
            if (mRealm != null) {
                mRealm.close();
            }
        }

        SharedPreferencesManager.setSharedPreferenceAs(SharedKeys.LOGIN, true, true);
        SharedPreferencesManager.setSharedPreferenceAs(SharedKeys.LOGIN_DATA, responseLogin, true);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        getActivity().startActivity(intent);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void onClickDoLogin() {
        presenter.validateCredentials(editTextUser.getText().toString(), editTextPass.getText().toString());
    }
}
