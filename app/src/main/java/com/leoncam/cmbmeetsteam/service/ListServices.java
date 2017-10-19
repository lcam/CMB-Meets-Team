package com.leoncam.cmbmeetsteam.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leoncam.cmbmeetsteam.model.TeamMember;
import com.leoncam.cmbmeetsteam.presenter.ListPresenter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListServices {
    private Context context;
    private ListPresenter presenter;
    public ListServices(Context context){
        this.context = context;
    }

    public List<TeamMember> fetchTeamMembers() {
        Gson gson = new Gson();
        return gson.fromJson(loadJSONFromAsset("team.json"), new TypeToken<ArrayList<TeamMember>>(){}.getType());
    }

    public String loadJSONFromAsset(String file) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public void setCallback(ListPresenter presenter){
        this.presenter = presenter;
    }

    public void loadData(){
        presenter.updateView(fetchTeamMembers());
    }
}
