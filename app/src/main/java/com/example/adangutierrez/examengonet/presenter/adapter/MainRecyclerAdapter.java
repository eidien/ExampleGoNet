package com.example.adangutierrez.examengonet.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adangutierrez.examengonet.R;
import com.example.adangutierrez.examengonet.data.model.Marcas;
import com.example.adangutierrez.examengonet.presenter.utils.GeneralUtils;
import com.squareup.picasso.Picasso;

import io.realm.RealmResults;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {

    Context context;
    RealmResults<Marcas> result;
    View.OnClickListener mListener;

    public MainRecyclerAdapter(Context context, RealmResults<Marcas> result, View.OnClickListener mListener) {
        this.context = context;
        this.result = result;
        this.mListener = mListener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.viewholder_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        holder.linearLayoutContainer.setTag(position);
        holder.linearLayoutContainer.setOnClickListener(mListener);

        Marcas marcas = result.get(position);

        Picasso.with(context).
                load(GeneralUtils.getResourceMarca(marcas.getIdResourceImagen()))
                .into(holder.imageViewLogo);

        holder.textViewName.setText(marcas.getType());
    }

    @Override
    public int getItemCount() {
        return result != null ? result.size() : 0;
    }
}
