package com.leoncam.cmbmeetsteam.dagger.modules;

import com.leoncam.cmbmeetsteam.presenter.ListPresenter;
import com.leoncam.cmbmeetsteam.service.ListServices;
import com.leoncam.cmbmeetsteam.view.MainListView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainListModule {
    MainListView activity;

    public MainListModule(MainListView activity){
        this.activity = activity;
    }

    @Provides
    ListPresenter provideGridPresenter(ListServices service){
        return new ListPresenter(activity, service);
    }

    @Provides
    ListServices provideListServices() {
        return new ListServices(activity);
    }
}
