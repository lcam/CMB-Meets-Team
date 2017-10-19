package com.leoncam.cmbmeetsteam.dagger.components;


import com.leoncam.cmbmeetsteam.dagger.modules.MainListModule;
import com.leoncam.cmbmeetsteam.view.MainListView;

import dagger.Subcomponent;

@Subcomponent(
        modules = {MainListModule.class}
)
public interface MainListComponent {
    void inject(MainListView mainListView);
}
