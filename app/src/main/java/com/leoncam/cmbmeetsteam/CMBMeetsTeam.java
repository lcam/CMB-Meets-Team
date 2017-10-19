package com.leoncam.cmbmeetsteam;

import android.app.Application;

import com.leoncam.cmbmeetsteam.dagger.components.ApplicationComponent;
import com.leoncam.cmbmeetsteam.dagger.components.DaggerApplicationComponent;


public class CMBMeetsTeam extends Application{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
