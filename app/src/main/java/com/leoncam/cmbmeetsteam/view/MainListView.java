package com.leoncam.cmbmeetsteam.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.leoncam.cmbmeetsteam.CMBMeetsTeam;
import com.leoncam.cmbmeetsteam.R;
import com.leoncam.cmbmeetsteam.dagger.components.MainListComponent;
import com.leoncam.cmbmeetsteam.dagger.modules.MainListModule;
import com.leoncam.cmbmeetsteam.model.TeamMember;
import com.leoncam.cmbmeetsteam.presenter.ListPresenter;
import com.leoncam.cmbmeetsteam.service.ListServices;

import java.util.List;

public class MainListView extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvMembers)
    RecyclerView rvItems;

    @Inject
    ListPresenter presenter;
    @Inject
    ListServices service;

    MainListComponent mainListComponent;
    Unbinder unbinder;
    private LinearLayoutManager layoutManager;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);
        unbinder = ButterKnife.bind(this);

        setMainListComponentComponent();
        setSupportActionBar(toolbar);

        getData();

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvItems.setLayoutManager(layoutManager);
    }

    private void setMainListComponentComponent() {
        mainListComponent = ((CMBMeetsTeam) getApplication()).getApplicationComponent()
                .plus(new MainListModule(this));
        mainListComponent.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void getData() {
        presenter.loadData();
    }

    public void updateList(List<TeamMember> teamMemberList) {
        adapter = new ListAdapter(getApplicationContext(), teamMemberList);
        rvItems.setAdapter(adapter);
    }
}
