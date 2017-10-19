package com.leoncam.cmbmeetsteam.presenter;


import com.leoncam.cmbmeetsteam.model.TeamMember;
import com.leoncam.cmbmeetsteam.service.ListServices;
import com.leoncam.cmbmeetsteam.view.MainListView;

import java.util.List;

public class ListPresenter {
    private MainListView view;
    private ListServices service;

    public ListPresenter(MainListView view, ListServices service) {
        this.view = view;
        this.service = service;
        service.setCallback(this);
    }

    public void loadData() {
        service.loadData();
    }

    public void updateView(List<TeamMember> teamMemberList) {
        view.updateList(teamMemberList);
    }
}
