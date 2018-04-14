package com.example.adangutierrez.examengonet.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adangutierrez.examengonet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adan.gutierrez on 14/04/18.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.container)
    LinearLayout linearLayoutContainer;

    @BindView(R.id.img_logo)
    ImageView imageViewLogo;

    @BindView(R.id.text_name)
    TextView textViewName;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
