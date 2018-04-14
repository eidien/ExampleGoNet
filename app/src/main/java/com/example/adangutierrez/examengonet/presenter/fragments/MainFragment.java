package com.example.adangutierrez.examengonet.presenter.fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.data.model.Marcas;
import com.example.adangutierrez.examengonet.presenter.activities.RecargaActivity;
import com.example.adangutierrez.examengonet.presenter.adapter.MainRecyclerAdapter;
import com.example.adangutierrez.examengonet.presenter.bases.BaseFragment;
import com.example.adangutierrez.examengonet.presenter.utils.GeneralUtils;
import com.example.adangutierrez.examengonet.presenter.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void onInitializeUI() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), GeneralUtils.isTablet() ? 4 : 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(GeneralUtils.isTablet() ? 4 : 3, getResources().getDimensionPixelSize(R.dimen.dimen_10), true));

        Realm mRealm = Realm.getDefaultInstance();
        final RealmResults<Marcas> results = mRealm.where(Marcas.class).findAll();
        if (results != null && results.size() > 0) {
            MainRecyclerAdapter adapter = new MainRecyclerAdapter(getActivity(), results, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Intent intent = new Intent(getActivity(), RecargaActivity.class);
                    getActivity().startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
        }
    }
}
