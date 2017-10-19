package com.leoncam.cmbmeetsteam.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.cmbmeetsteam.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @BindView(R.id.team_member)
        View teamMember;
    @BindView(R.id.image_avatar)
        ImageView imageAvatar;
    @BindView(R.id.text_name)
        TextView textName;
    @BindView(R.id.text_title)
        TextView textTitle;

    public IMyViewHolderClicks listener;

    public ListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick({
            R.id.team_member
    })
    public void onClick(View view) {
        listener.onTeamMember(view);
    }

    public interface IMyViewHolderClicks {
        void onTeamMember(View caller);
    }
}
