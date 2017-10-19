package com.leoncam.cmbmeetsteam.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.cmbmeetsteam.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsPageView extends AppCompatActivity{
    @BindView(R.id.image_avatar_large)
        ImageView imageAvatarLarge;
    @BindView(R.id.text_name_detail)
        TextView textNameDetail;
    @BindView(R.id.text_title_detail)
        TextView textTitleDetail;
    @BindView(R.id.text_bio)
        TextView textBio;

    String image;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        ButterKnife.bind(this);

        text = getIntent().getStringExtra("name");
        textNameDetail.setText(text);

        text = getIntent().getStringExtra("title");
        textTitleDetail.setText(text);

        text = getIntent().getStringExtra("bio");
        textBio.setText(text);

        image = getIntent().getStringExtra("avatar");
        Picasso.with(this)
                .load(image)
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .fit()
                .centerInside()
                .into(imageAvatarLarge);
    }
}
