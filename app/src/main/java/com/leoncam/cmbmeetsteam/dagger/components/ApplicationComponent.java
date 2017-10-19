package com.leoncam.cmbmeetsteam.dagger.components;

import com.leoncam.cmbmeetsteam.CMBMeetsTeam;
import com.leoncam.cmbmeetsteam.dagger.modules.AppModule;
import com.leoncam.cmbmeetsteam.dagger.modules.MainListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class}
)
public interface ApplicationComponent {
    void inject(CMBMeetsTeam cmbMeetsTeam);

    MainListComponent plus(MainListModule mainListModule);
}
