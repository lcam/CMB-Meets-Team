package com.leoncam.cmbmeetsteam.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leoncam.cmbmeetsteam.R;
import com.leoncam.cmbmeetsteam.model.TeamMember;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder>{
    private List<TeamMember> teamMemberList;
    private TeamMember teamMember;
    private final Context context;

    public ListAdapter(Context context, List<TeamMember> teamMember) {
        this.teamMemberList = teamMember;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.team_member, parent, false);

        // Return a new holder instance
        final ListViewHolder viewHolder = new ListViewHolder(itemView);
        viewHolder.listener = new ListViewHolder.IMyViewHolderClicks() {
            @Override
            public void onTeamMember(View caller) {
                final int position = viewHolder.getAdapterPosition();
                teamMember = teamMemberList.get(position);

                Intent intent = new Intent(caller.getContext(), DetailsPageView.class);
                intent.putExtra("avatar", teamMember.getAvatar());
                intent.putExtra("name", String.format("%s %s",
                        teamMember.getFirstName(), teamMember.getLastName()));
                intent.putExtra("title", teamMember.getTitle());
                intent.putExtra("bio", teamMember.getBio());
                caller.getContext().startActivity(intent);
            }
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder viewHolder, int position) {
        teamMember = teamMemberList.get(position);

        viewHolder.textName.setText(String.format("%s %s",
                teamMember.getFirstName(), teamMember.getLastName()));
        viewHolder.textTitle.setText(teamMember.getTitle());

        Picasso.with(viewHolder.imageAvatar.getContext())
                .load(teamMember.getAvatar())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .resize(300, 300)
                .centerCrop()
                .into(viewHolder.imageAvatar);
    }

    @Override
    public int getItemCount() {
        return teamMemberList.size();
    }
}
